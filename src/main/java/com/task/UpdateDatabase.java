package com.task;

import com.pojo.View;
import com.service.ViewService;
import org.fusesource.hawtbuf.Buffer;
import org.fusesource.hawtbuf.UTF8Buffer;
import org.fusesource.mqtt.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;


//@Component
public class UpdateDatabase{


    private static String HOST = "tcp://127.0.0.1:61613";
    private static String USERNAME = "admin";
    private static String PASSWORD = "password";
    private final static boolean CLEAN_START = true;
    private final static short KEEP_ALIVE = 30;// 低耗网络，但是又需要及时获取数据，心跳30s
    public final static long RECONNECTION_ATTEMPT_MAX = 6;
    public final static long RECONNECTION_DELAY = 2000;
    public final static int SEND_BUFFER_SIZE = 2 * 1024 * 1024;// 发送最大缓冲为2M



    public static Topic[] getWrite() {     //得到要订阅的
        Topic[] get=new Topic[5];
        for(int i=0;i<5;i++) {
            String getstring[]=new String[100];
            getstring[i]="msg"+i;
            Topic topic=new Topic(getstring[i], QoS.EXACTLY_ONCE);
            get[i]=topic;
        }
        return get;

    }
    int counter=0;
    //@Scheduled( fixedDelay = 600000)
    public void UpdateDatabase(ViewService viewService) {

        final ViewService viewService1;

        viewService1 = viewService;

        try { // 创建MQTT对象
            MQTT mqtt = new MQTT();
            mqtt.setClientId("CallbackClient");
            mqtt.setHost(HOST);
            mqtt.setUserName(USERNAME);
            mqtt.setPassword(PASSWORD);
            mqtt.setCleanSession(CLEAN_START);
            mqtt.setReconnectAttemptsMax(RECONNECTION_ATTEMPT_MAX);
            mqtt.setReconnectDelay(RECONNECTION_DELAY);
            mqtt.setKeepAlive(KEEP_ALIVE);
            mqtt.setSendBufferSize(SEND_BUFFER_SIZE);
            CallbackConnection connection = mqtt.callbackConnection();

            //连接
            connection.connect(new Callback<Void>() {
                //可以在connect的onSuccess方法中发布或者订阅相应的主题
                public void onSuccess(Void oid) {
                    //进入该方法表示连接成功连接成功
                    System.out.println("连接成功：" + oid);
                }

                //onFailure方法中作相应的断开连接等操作
                public void onFailure(Throwable cause) {
                    //进入该方法表示连接失败
                    System.out.println("连接失败");
                }
            });

            //调用方法
            Topic[] get = getWrite();

            //监听
            connection.listener(new Listener() {
                //表示成功，可以获取到订阅的主题和订阅的内容（UTF8Buffer topicmsg表示订阅的主题,
                //Buffer msg表示订阅的类容），一般的可以在这个方法中获取到订阅的主题和内容然后进行相应的判断和其他业务逻辑操作；
                public void onPublish(UTF8Buffer topicmsg, Buffer msg, Runnable ack) {
                    //utf-8 is used for dealing with the garbled
                    String topic = topicmsg.utf8().toString();
                    String payload = msg.utf8().toString();
                    System.out.println("topic:" + topic);
                    System.out.println("message:" + payload);//表示监听成功
                    String write = new String();
                    String writeid = new String();
                    write = payload;
                    writeid = topic;

                    //使用string的方法将msg分离出来,插入数据库
                    String[] writes = write.split(",");
                    View view = new View();
                    view.setId( Integer.parseInt(writes[0]));
                    view.setPressure(writes[1]);
                    view.setTemperature(writes[2]);
                    view.setHumidity(writes[3]);
                    view.setCo2( writes[4]);
                    view.setC2h2(writes[5]);
                    view.setTime(Date.valueOf(writes[6]));

                    if(viewService1.queryById(Integer.parseInt(writes[0]))==null){
                        viewService1.addView(view);
                    }
                    ack.run();
                }

                //表示监听失败，这里可以调用相应的断开连接等方法；
                public void onFailure(Throwable arg0) {
                    //表示监听失败
                }

                //表示监听到连接建立，该方法只在建立连接成功时执行一次，
                //表示连接成功建立，如果有必要可以在该方法中进行相应的订阅操作；
                public void onDisconnected() {
                    //表示监听到断开连接
                }

                //表示监听到连接断开，该方法只在断开连接时执行一次，如有必要可以进行相应的资源回收操作。
                public void onConnected() {
                    //表示监听到连接成功
                }
            });

            //订阅
            connection.subscribe(get, new Callback<byte[]>() {
                //Topic[] topics表示订阅的主题数组，注意只有在这个方法订阅的主题，才能够在监听方法中接收到。
                public void onSuccess(byte[] qoses) {
                    //主题订阅成功
                    System.out.println("订阅成功:" + new String(qoses));
                }

                public void onFailure(Throwable arg0) {
                    //状态主题订阅失败
                    System.out.println("订阅失败");
                }
            });

            //回调将执行与连接相关联的调度队列，以便可以安全使用从回调的连接，但你绝不能在回调中执行任何阻塞操作，否则会改变执行的顺序，
            //这样可能出错。如果可能存在阻塞时，最好是在连接的调度队列中执行另外一个线程
            connection.getDispatchQueue().execute(new Runnable() {
                public void run() {
                    //在这里进行相应的订阅、发布、停止连接等等操作
                }
            });

        }catch (Exception e){}

    }
}

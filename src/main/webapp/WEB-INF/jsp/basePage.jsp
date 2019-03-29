<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<head>
    <title>View列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入可视化echarts图表js -->
    <script type="text/javascript" src="../js/echarts.min.js"></script>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1 align="center">
                    监控端实现页面
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>当前运行数据</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>压力</th>
                    <th>温度</th>
                    <th>湿度</th>
                    <th>co2浓度</th>
                    <th>c2h2浓度</th>
                    <th>时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="view" items="${requestScope.get('list')}" varStatus="status">
                    <tr>
                        <td>${view.pressure}</td>
                        <td>${view.temperature}</td>
                        <td>${view.humidity}</td>
                        <td>${view.co2}</td>
                        <td>${view.c2h2}</td>
                        <td>${view.time}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div>
    <span id="chartmain" style="width:500px; height: 400px; float: left;"></span>
    <span id="chartmain2" style="width:500px; height: 400px; float: right;"></span>
    </div>
    <div>
        <span id="chartmain3" style="width:500px; height: 400px; float: left;"></span>
        <span id="chartmain4" style="width:500px; height: 400px; float: right;"></span>
    </div>
</div>
</body>
<script type="text/javascript">

    var time = ('${s}');

    var timeget=JSON.parse(time);
    var yali =("${yali}");

    Date.prototype.format = function(format){
        var o = {
            "M+" : this.getMonth()+1, //month
            "d+" : this.getDate(), //day
            "H+" : this.getHours(), //hour
            "m+" : this.getMinutes(), //minute
            "s+" : this.getSeconds(), //second
            "q+" : Math.floor((this.getMonth()+3)/3), //quarter
            "S" : this.getMilliseconds() //millisecond
        }

        if(/(y+)/.test(format)) {
            format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
        }

        for(var k in o) {
            if(new RegExp("("+ k +")").test(format)) {
                format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
            }
        }
        return format;
    }


    //指定图标的配置和数据
    var option = {
        title:{
            text:'顶板压力变化图'
        },
        tooltip:{},
        legend:{
            data:['用户来源']
        },
        xAxis:{
            data:[(new Date(parseFloat(timeget[4].time.time))).format("yyyy-MM-dd HH:mm:ss"),
                  (new Date(parseFloat(timeget[3].time.time))).format("yyyy-MM-dd HH:mm:ss"),
                  (new Date(parseFloat(timeget[2].time.time))).format("yyyy-MM-dd HH:mm:ss"),
                  (new Date(parseFloat(timeget[1].time.time))).format("yyyy-MM-dd HH:mm:ss"),
                  (new Date(parseFloat(timeget[0].time.time))).format("yyyy-MM-dd HH:mm:ss")]
            ,
            "type":"category"
            ,
            "axisLabel": {
                interval:0,
                rotate:40
            }
        },
        yAxis:{

        },
        series:[{
            name:'顶板压力',
            type:'line',
            data:[timeget[4].pressure,timeget[3].pressure,timeget[2].pressure,timeget[1].pressure,timeget[0].pressure]
        }]
    };
    var option2 = {
        title:{
            text:'气体浓度变化'
        },
        tooltip:{},
        legend:{
            data:['用户来源']
        },
        xAxis:{
            data:[(new Date(parseFloat(timeget[4].time.time))).format("yyyy-MM-dd HH:mm:ss"),
                (new Date(parseFloat(timeget[3].time.time))).format("yyyy-MM-dd HH:mm:ss"),
                (new Date(parseFloat(timeget[2].time.time))).format("yyyy-MM-dd HH:mm:ss"),
                (new Date(parseFloat(timeget[1].time.time))).format("yyyy-MM-dd HH:mm:ss"),
                (new Date(parseFloat(timeget[0].time.time))).format("yyyy-MM-dd HH:mm:ss")]
            ,
            "type":"category"
            ,
            "axisLabel": {
                interval:0,
                rotate:40
            }
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            name: 'CO2浓度',
            data: [timeget[4].pressure, timeget[3].pressure, timeget[2].pressure, timeget[1].pressure, timeget[0].pressure],
            type: 'line',
            symbol: 'triangle',
            symbolSize: 20,
            lineStyle: {
                normal: {
                    color: 'green',
                    width: 4,
                    type: 'dashed'
                }
            },
            itemStyle: {
                normal: {
                    borderWidth: 3,
                    borderColor: 'yellow',
                    color: 'blue'
                }
            }
        },
            {
            name:'C2H2浓度',
            data:[timeget[0].pressure,timeget[3].pressure,timeget[2].pressure,timeget[1].pressure,timeget[0].pressure],
            type: 'line',
            symbol: 'triangle',
            symbolSize: 20,
        }]
    };
    //初始化echarts实例
    var myChart = echarts.init(document.getElementById('chartmain'));
    var myChart2 = echarts.init(document.getElementById('chartmain2'));
    var myChart3 = echarts.init(document.getElementById('chartmain3'));
    var myChart4 = echarts.init(document.getElementById('chartmain4'));
    //使用制定的配置项和数据显示图表
    myChart.setOption(option);
    myChart2.setOption(option);
    myChart3.setOption(option);
    myChart4.setOption(option2);

    //var string=(new Date(parseFloat(timeget[0].time.time))).format("yyyy-MM-dd HH:mm:ss");

    //alert(string);

</script>
</html>
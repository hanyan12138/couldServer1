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
<div id="right" style="width: 80%; float: right">
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
    <div id="chartmain" style="width:600px; height: 400px;"></div>
</div>
</div>
</body>
<script type="text/javascript">
    //指定图标的配置和数据
    var option = {
        title:{
            text:'ECharts 数据统计'
        },
        tooltip:{},
        legend:{
            data:['用户来源']
        },
        xAxis:{
            data:["Android","IOS","PC","Ohter"]
        },
        yAxis:{

        },
        series:[{
            name:'访问量',
            type:'line',
            data:[500,200,360,100]
        }]
    };
    //初始化echarts实例
    var myChart = echarts.init(document.getElementById('chartmain'));

    //使用制定的配置项和数据显示图表
    myChart.setOption(option);
</script>
</html>
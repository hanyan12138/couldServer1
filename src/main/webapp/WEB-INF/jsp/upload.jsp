<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>View列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入可视化echarts图表js -->
    <script type="text/javascript" src="../js/echarts.min.js"></script>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form method="post" enctype="multipart/form-data" action="<%=basePath %>/upload/addImg" >
    <input type="file" name="pictureFile" id="pictureFile" value="请选择图片" />
    <input  type="submit" >提交</input>
</form>
</body>
</html>
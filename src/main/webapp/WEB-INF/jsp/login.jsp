<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!doctype html>

<html>

<head>

    <meta charset="utf-8">
    <title>login</title>
    <style type="text/css">
        *{

            margin: 0;
            padding: 0;

        }

        #wrap {

            height: 719px;
            width: 100%;
            background-image: url(../img/loginbeijing.png);
            background-repeat: no-repeat;
            background-position: center center;
            position: relative;
        }

        #head {
            height: 120px;
            width: 100%;
            background-color: #66CCCC;
            text-align: center;
            position: relative;
        }

        #foot {
            width: 100%;
            height: 126px;
            background-color: #CC9933;
            position: relative;
        }

        #wrap .logGet {
            height: 408px;
            width: 368px;
            position: absolute;
            background-color: #FFFFFF;
            top: 20%;
            right: 15%;

        }

        .logC a button {
            width: 100%;
            height: 45px;
            background-color: #ee7700;
            border: none;
            color: white;
            font-size: 18px;

        }

        .logGet .logD.logDtip .p1 {
            display: inline-block;
            font-size: 28px;
            margin-top: 30px;
            width: 86%;
        }

        #wrap .logGet .logD.logDtip {
            width: 86%;
            border-bottom: 1px solid #ee7700;
            margin-bottom: 60px;
            margin-top: 0px;
            margin-right: auto;
            margin-left: auto;

        }

        .logGet .lgD img {
            position: absolute;
            top: 12px;
            left: 8px;
        }

        .logGet .lgD input {
            width: 100%;
            height: 42px;
            text-indent: 2.5rem;
        }

        #wrap .logGet .lgD {
            width: 86%;
            position: relative;
            margin-bottom: 30px;
            margin-top: 30px;
            margin-right: auto;
            margin-left: auto;

        }

        #wrap .logGet .logC {

            width: 86%;
            margin-top: 0px;
            margin-right: auto;
            margin-bottom: 0px;
            margin-left: auto;

        }

        .title {

            font-family: "宋体";
            color: #FFFFFF;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);  /* 使用css3的transform来实现 */
            font-size: 36px;
            height: 40px;
            width: 30%;
        }

        .copyright {

            font-family: "宋体";
            color: #FFFFFF;
            position: absolute;
            top: 50%;
            left: 50%;
            trnsform: translate(-50%, -50%);  /* 使用css3的transform来实现 */
            height: 60px;
            width: 40%;
            text-align:center;
        }

        #foot .copyright .img {

            width: 100%;
            height: 24px;
            position: relative;
        }

        .copyright .img .icon {
            display: inline-block;
            width: 24px;
            height: 24px;
            margin-left: 22px;
            vertical-align: middle;
            background-image: url(loginbeijing.png);
            background-repeat: no-repeat;
            vertical-align: middle;
            margin-right: 5px;
        }

        .copyright .img .icon1 {

            display: inline-block;
            width: 24px;
            height: 24px;
            margin-left: 22px;
            vertical-align: middle;
            background-image: url(loginbeijing.png);
            background-repeat: no-repeat;
            vertical-align: middle;
            margin-right: 5px;

        }

        .copyright .img .icon2 {

            display: inline-block;
            width: 24px;
            height: 24px;
            margin-left: 22px;
            vertical-align: middle;
            background-image: url(loginbeijing.png);
            background-repeat: no-repeat;
            vertical-align: middle;
            margin-right: 5px;

        }

        #foot .copyright p {

            height: 24px;
            width: 100%;

        }

    </style>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <!-- CSS样式 -->

</head>



<body>

<div class="header" id="head">

    <div class="title">矿井风险识别与预警系统</div>

</div>



<div class="wrap" id="wrap">

    <div class="logGet">

        <!-- 头部提示信息 -->

        <div class="logD logDtip">
            <p class="p1">登录</p>
        </div>

        <!-- 输入框 -->
        <form action="" name="userForm">
        <div class="lgD">
            <img src="../img/name.png" width="20" height="20" alt=""/>
            <input type="text" id="username" name="userName"
                   placeholder="输入用户名" />
        </div>

        <div class="lgD">
            <img src="../img/password.png" width="20" height="20" alt=""/>
            <input type="text" id="password" name="userPassword"
                   placeholder="输入用户密码" />
        </div>
        </form>
        <div class="logC" onclick="formsubmit()">
            <a target="_self" ><button >登 录</button></a>
        </div>
    </div>
</div>

<div class="footer" id="foot">
    <div class="copyright">
    </div>
</div>

</body>
<script type="text/javascript">
    function formsubmit() {
        var form = document.forms[0];
        form.action = "<%=basePath %>warning/logining";
        form.method = "post";
        form.submit();
    }
</script>


</html>


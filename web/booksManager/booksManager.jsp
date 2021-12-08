<%@ page import="com.dark.model.Admin" %><%--
  Created by IntelliJ IDEA.
  User: dark
  Date: 2021/11/23
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>图书商店后台管理系统</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            border: 0;
            overflow: hidden;
            height: 100%;
            max-height: 100%;
        }

        #frameTop {
            position: absolute;
            top: 0;
            left: 0;
            height: 100px;
            width: 100%;
            overflow: hidden;
            vertical-align: middle;
        }

        #frameContentLeft {
            position: fixed;
            top: 100px;
            left: 0;
            height: 100%;
            width: 150px;
            overflow: hidden;
            vertical-align: top;
            background-color: #D2E6FA;
        }

        #frameContentRight {
            position: absolute;
            left: 150px;
            top: 100px;
            height: 100%;
            width: 100%;
            right: 0;
            bottom: 0;
            overflow: hidden;
            background: #fff;
        }
    </style>
</head>
<body>

<div>
    <iframe id="frameTop" src="header.jsp"></iframe>
</div>

<div>
    <iframe id="frameContentLeft" src="left.jsp"></iframe>
    <iframe id="frameContentRight" src="" name="right"></iframe>
</div>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: dark
  Date: 2021/11/22
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        p,h1{
            text-align: center;
            margin-bottom: 50px;
        }
        h1{
            margin-top: 50px;
        }
        input{
            height: 30px;
        }
    </style>
</head>
<body>
<h1>后台管理系统</h1>
<form action="login.do" method="post">
    <p>
        <input type="text" name="account" placeholder="请输入用户名">
    </p>
    <p>
        <input type="password" name="password" placeholder="请输入密码">
    </p>
    <p>
        <input type="submit"  value="登录">
    </p>
</form>
</body>
</html>

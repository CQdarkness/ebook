<%--
  Created by IntelliJ IDEA.
  User: dark
  Date: 2021/11/23
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Title</title>
    <style>
        *{
            margin: 0;
            padding:0;
        }
        ul{
            list-style: none;
        }
        a{
            text-decoration: none;
        }
        .dropdown{
            margin: 0 auto;
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
<div class="dropdown">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false">
        分类管理
    </button>
    <div class="dropdown-menu" >
        <a class="dropdown-item" href="category_display.jsp" target="right">分类展示</a>
        <a class="dropdown-item" href="category_add.jsp" target="right">增加分类</a>
<%--        <a class="dropdown-item" href="category_update.jsp" target="right">更新分类</a>--%>
    </div>
</div>
<%--<br><br><br><br><br>--%>
<div class="dropdown">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2" data-toggle="dropdown" aria-expanded="false">
        商品管理
    </button>
    <div class="dropdown-menu" >
        <a class="dropdown-item" href="goods.do?req=display" target="right">商品展示</a>
        <a class="dropdown-item" href="goods_add.jsp" target="right">添加商品</a>
<%--        <a class="dropdown-item" href="#" target="right">更新商品</a>--%>
    </div>
</div>
<div class="dropdown">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton3" data-toggle="dropdown" aria-expanded="false">
        用户管理
    </button>
    <div class="dropdown-menu" >
        <a class="dropdown-item" href="order.do?op=user" target="right">用户展示</a>
        <a class="dropdown-item" href="user_edit.jsp" target="right">修改用户</a>
        <%--        <a class="dropdown-item" href="#" target="right">更新商品</a>--%>
    </div>
</div>
<div class="dropdown">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton4" data-toggle="dropdown" aria-expanded="false">
        订单管理
    </button>
    <div class="dropdown-menu" >
        <a class="dropdown-item" href="order.do?op=ss" target="right">订单展示</a>
        <a class="dropdown-item" href="order_edit.jsp" target="right">修改订单</a>
        <%--        <a class="dropdown-item" href="#" target="right">更新商品</a>--%>
    </div>
</div>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

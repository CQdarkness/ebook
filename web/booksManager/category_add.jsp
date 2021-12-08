<%--
  Created by IntelliJ IDEA.
  User: dark
  Date: 2021/11/23
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<form action="category.do" method="post" >
    <!--利用隐藏域分辨表单类型-->
    <input type="hidden" name="op" value="add">
    <div class="form-group">
        <label for="exampleInputEmail1">类型名称</label>
        <input type="text" class="form-control" id="exampleInputEmail1" name="name">
    </div>
    <div class="form-group form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1" name="navable" value="y">
        <label class="form-check-label" for="exampleCheck1">是否为导航</label>
    </div>
    <button type="submit" class="btn btn-primary">添加</button>
</form>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

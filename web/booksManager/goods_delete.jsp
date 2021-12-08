<%--
  Created by IntelliJ IDEA.
  User: dark
  Date: 2021/11/23
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<script>
    alert("确认删除？")
</script>
<form class="form-inline" action="goods.do" method="post">
    <!--利用隐藏域分辨表单类型-->
    <input type="hidden" name="op" value="delete">
    <input type="hidden" name="deleteId" value=<%= request.getParameter("id")%>>
    <button type="submit" class="btn btn-primary mb-2">确认删除</button>
</form>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

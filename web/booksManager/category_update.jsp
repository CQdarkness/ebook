<%--
  Created by IntelliJ IDEA.
  User: dark
  Date: 2021/11/23
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<form class="form-inline" action="category.do" method="post">
    <!--利用隐藏域分辨表单类型-->
    <input type="hidden" name="op" value="update">
    <input type="hidden" name="updateId" value=<%= request.getParameter("id")%>>
    <%System.out.println(request.getParameter("id"));%>
    <div class="form-group mx-sm-3 mb-2">
        <input type="text" class="form-control" placeholder="输入新的类别名称" name="name">
    </div>
    <div class="form-group mx-sm-3 mb-2">
        <label for="status" class="form-check-label">是否有效</label>
        <input type="checkbox" class="form-control" id="status"  name="status" value="y">
    </div>
    <div class="form-group mx-sm-3 mb-2">
        <label for="navable" class="form-check-label">是否导航</label>
        <input type="checkbox" class="form-control" id="navable"  name="navable" value="y">
    </div>
    <div class="form-group mx-sm-3 mb-2">
        <input type="number" class="form-control" placeholder="优先级" name="sort">
    </div>
    <button type="submit" class="btn btn-primary mb-2">Confirm identity</button>
</form>
</body>
</html>

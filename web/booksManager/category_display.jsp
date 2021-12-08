<%@ page import="com.dark.model.Category" %>
<%@ page import="com.dark.service.CategoryService" %>
<%@ page import="com.dark.service.impl.CategoryServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%
    CategoryService categoryService=new CategoryServiceImpl();
    List<Category> allCategory = categoryService.findAllCategory();
%>
<table class="table">
    <thead class="thead-light">
    <tr>
        <th scope="col">id</th>
        <th scope="col">名称</th>
        <th scope="col">导航</th>
        <th scope="col">优先级</th>
        <th scope="col">状态</th>
        <th scope="col">操作</th>
    </tr>
    </thead>
    <tbody>
    <%for(Category category:allCategory){%>
    <tr>
        <th scope="row"><%=category.getId()%></th>
        <td><%=category.getName()%></td>
        <td><%=category.getNavable()%></td>
        <td><%=category.getStatus()%></td>
        <td><%=category.getSort()%></td>
        <%request.getSession().setAttribute("category",category);%>
        <td><a href="category_update.jsp?id=<%=category.getId()%>" target="right">编辑</a>&nbsp <a href="">删除</a></td>
    </tr>
    <%}%>
    </tbody>
</table>
</body>
</html>

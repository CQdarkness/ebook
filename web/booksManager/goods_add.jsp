<%@ page import="com.dark.service.CategoryService" %>
<%@ page import="com.dark.service.impl.CategoryServiceImpl" %>
<%@ page import="com.dark.model.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: dark
  Date: 2021/11/23
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        .con{
            height: 90%;
            width: 90%;
            overflow: scroll;
        }
    </style>
</head>
<body>
<div class="con">
    <form action="goods.do" method="post">
        <!--利用隐藏域分辨表单类型-->
        <input type="hidden" name="op" value="add">
        <div class="form-group">
            <label for="name">商品名称</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="goodsno">商品编号</label>
            <input type="text" class="form-control" id="goodsno" name="goodsno">
        </div>
        <div class="form-group">
            <label for="author">作者</label>
            <input type="text" class="form-control" id="author" name="author">
        </div>
        <div class="form-group">
            <label for="publisher">出版社</label>
            <input type="text" class="form-control" id="publisher" name="publisher">
        </div>
        <div class="form-group">
            <label for="pubtime">出版时间</label>
            <input type="date" class="form-control" id="pubtime" name="pubtime">
        </div>
        <div class="form-group">
<%--            <label for="categoryid">类别ID</label>--%>
<%--            <input type="text" class="form-control" id="categoryid" name="categoryid">--%>
            类别:
            <select name="categoryid" id="categoryid">
                <%
                    CategoryService categoryService = new CategoryServiceImpl();
                    List<Category> allCategory = categoryService.findAllCategory();
                    for (Category category : allCategory) {%>
                <option value="<%=category.getId()%>"><%=category.getName()%>
                </option>
                <%}%>
            </select>
        </div>
        <div class="form-group">
            <label for="description">描述</label>
            <input type="text" class="form-control" id="description" name="description">
        </div>
        <div class="form-group">
            <label for="image">图片</label>
            <input type="text" class="form-control" id="image" name="image">
        </div>
        <div class="form-group">
            <label for="stock">库存</label>
            <input type="text" class="form-control" id="stock" name="stock">
        </div>
        <div class="form-group">
            <label for="marketprice">市场价</label>
            <input type="text" class="form-control" id="marketprice" name="marketprice">
        </div>
        <div class="form-group">
            <label for="salesprice">销售价</label>
            <input type="text" class="form-control" id="salesprice" name="salesprice">
        </div>
        <div class="form-group">
            <label for="uptime">上架时间</label>
            <input type="date" class="form-control" id="uptime" name="uptime">
        </div>
        <div class="form-group">
            <label for="downtime">下架时间</label>
            <input type="date" class="form-control" id="downtime" name="downtime">
        </div>
        <div class="form-group">
            <label for="salenums">销售量</label>
            <input type="text" class="form-control" id="salenums" name="salenums">
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="newest" name="newest" value="y">
            <label class="form-check-label" for="newest">是否为最新</label>
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="hot" name="hot" value="y">
            <label class="form-check-label" for="hot">是否为热销</label>
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="status" name="status" value="y">
            <label class="form-check-label" for="status">状态</label>
        </div>
        <button type="submit" class="btn btn-primary">添加</button>
    </form>
</div>
</body>
</html>

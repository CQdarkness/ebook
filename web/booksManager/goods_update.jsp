<%@ page import="com.dark.model.Category" %>
<%@ page import="com.dark.model.Goods" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.dark.service.CategoryService" %>
<%@ page import="com.dark.service.impl.CategoryServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dark.service.GoodsService" %>
<%@ page import="com.dark.service.impl.GoodsServiceImpl" %><%--
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
            width: 90%;
            overflow: scroll;
        }
    </style>
</head>
<body>
<%
    String id = request.getParameter("id");
    GoodsService goodsService=new GoodsServiceImpl();
    Goods goods = goodsService.findGoodsById(Integer.parseInt(id));
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
%>
<div class="con">
<form class="form-inline" action="goods.do" method="post">
    <!--利用隐藏域分辨表单类型-->
    <input type="hidden" name="op" value="update">
    <input type="hidden" name="updateId" value=<%= request.getParameter("id")%>>
    <%System.out.println(request.getParameter("id"));%>
    <div class="form-group mx-sm-3 mb-2">
        名称:
        <input type="text" class="form-control" placeholder="名称" name="name" value="<%=goods.getName()%>">
    </div>
    <div class="form-group mx-sm-3 mb-2">
        编号:
        <input type="text" class="form-control" placeholder="编号" name="goodsno" value="<%=goods.getGoodsno()%>">
    </div>
    <div class="form-group mx-sm-3 mb-2">
        作者:
        <input type="text" class="form-control" placeholder="作者" name="author" value="<%=goods.getAuthor()%>">
    </div>
    <div class="form-group mx-sm-3 mb-2">
        出版社:
        <input type="text" class="form-control" placeholder="出版社" name="publisher" value="<%=goods.getPublisher()%>">
    </div>
    <div class="form-group mx-sm-3 mb-2">
        出版时间:
        <input type="text" class="form-control" placeholder="出版时间" name="pubtime" value="<%=goods.getPubtime()%>">
    </div>
<%--    <div class="form-group mx-sm-3 mb-2">--%>
<%--        <input type="number" class="form-control" placeholder="分类编号" name="categoryid" value="<%=goods.getCategoryid()%>">--%>
<%--    </div>--%>
    <div class="form-group mx-sm-3 mb-2">
    类别:
    <select name="categoryid" id="categoryid">
        <%CategoryService categoryService = new CategoryServiceImpl();
            List<Category> allCategory = categoryService.findAllCategory();
            for (Category category : allCategory) {%>
        <option value="<%=category.getId()%>"><%=category.getName()%>
        </option>
        <%}%>
    </select>
    </div>
    <div class="form-group mx-sm-3 mb-2">
        描述:
        <input type="text" class="form-control" placeholder="描述" name="description" value="<%=goods.getDescription()%>">
    </div>
    <div class="form-group mx-sm-3 mb-2">
        图片:
        <input type="text" class="form-control" placeholder="图片" name="image" value="<%=goods.getImage()%>">
    </div>
    <div class="form-group mx-sm-3 mb-2">
        库存:
        <input type="text" class="form-control" placeholder="库存" name="stock" value="<%=goods.getStock()%>">
    </div>
    <div class="form-group mx-sm-3 mb-2">
        市场价:
        <input type="text" class="form-control" placeholder="市场价" name="marketprice" value="<%=goods.getMarketprice()%>">
    </div>
    <div class="form-group mx-sm-3 mb-2">
        销售价:
        <input type="text" class="form-control" placeholder="销售价" name="salesprice" value="<%=goods.getSalesprice()%>">
    </div>
    <div class="form-group mx-sm-3 mb-2">
        上架时间:
        <input type="date" class="form-control" placeholder="上架时间" name="uptime" value="<%=goods.getUptime()==null?null:simpleDateFormat.format(goods.getUptime())%>">
    </div>
    <div class="form-group mx-sm-3 mb-2">
<%--        下架时间:--%>
<%--        <input type="date" class="form-control" placeholder="下架时间" name="downtime" value="<%=goods.getDowntime()==null?null:simpleDateFormat.format(goods.getDowntime())%>">--%>
<%--    </div>--%>
    <div class="form-group mx-sm-3 mb-2">
        销售数量:
        <input type="text" class="form-control" placeholder="销售数量" name="salenums" value="<%=goods.getSalenums()%>">
    </div>
    <div class="form-group mx-sm-3 mb-2">
        <label for="newest" class="form-check-label">是否最新</label>
        <input type="checkbox" class="form-control" id="newest"  name="newest" value="y" checked>
    </div>
    <div class="form-group mx-sm-3 mb-2">
        <label for="hot" class="form-check-label">是否热销</label>
        <input type="checkbox" class="form-control" id="hot"  name="hot" value="y" checked>
    </div>
    <div class="form-group mx-sm-3 mb-2">
        <label for="status" class="form-check-label">状态</label>
        <input type="checkbox" class="form-control" id="status"  name="status" value="y" checked>
    </div>
    <button type="submit" class="btn btn-primary mb-2">提交</button>
</form>
</div>
</body>
</html>

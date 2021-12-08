<%@ page import="com.dark.model.Goods" %>
<%@ page import="com.dark.service.GoodsService" %>
<%@ page import="com.dark.service.impl.GoodsServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: dark
  Date: 2021/11/24
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bookStyle.css">
</head>
<body>
<%
    String id = request.getParameter("id");
    GoodsService goodsService=new GoodsServiceImpl();
    Goods goods = goodsService.findGoodsById(Integer.parseInt(id));
%>
<section id="book">
    <div class="imgLeft"><img src="<%=goods.getImage()%>" alt="<%=goods.getGoodsno()%>"></div>
    <div class="textRight">
        <h1><%=goods.getName()%></h1>
        <p class="intro"><%=goods.getDescription()%></p>
        <p id="author"><%=goods.getAuthor()%></p>
        <div class="price">
            <div id="jdPrice">京东价： <span>￥<%=goods.getMarketprice()%></span> [6.9折] <p>[定价：<span>￥<%=goods.getSalesprice()%></span>]</p> (降价通知)</div>
<%--            <p id="mobilePrice">促销信息：<span>手机专享价</span> <span>￥9.90</span></p>--%>
            <dl>
                <dt>以下促销可在购物车任选其一</dt>
                <dd><span>加价购</span> 满99.00元另加6.18元即可在购物车换购热销商品</dd>
                <dd><span>满减</span> 满100.00减20.00，满200.00减60.00，满300.00减100.00</dd>
            </dl>
            <p id="ticket">领 券：<span>105-6</span>  <span>200-16</span></p>
        </div>
    </div>
</section>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/book.js"></script>
</body>
</html>

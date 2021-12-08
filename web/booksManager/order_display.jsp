<%@ page import="com.dark.service.GoodsService" %>
<%@ page import="com.dark.service.impl.GoodsServiceImpl" %>
<%@ page import="com.dark.model.Goods" %>
<%@ page import="java.util.List" %>
<%@ page import="com.github.pagehelper.PageInfo" %>
<%@ page import="com.dark.model.Category" %>
<%@ page import="com.dark.service.CategoryService" %>
<%@ page import="com.dark.service.impl.CategoryServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        .con {
            width: 90%;
            overflow: scroll;
        }

        .foot {
            width: 90%;
        }

        .pages {
            float: right;
            margin-right: 50px;
        }

        .seleA {
            background-color: #c6c8ca;
        }

        .selePreA {
            background-color: #c6c8ca;
            width: 60px;
        }

        .seleNextA {
            background-color: #c6c8ca;
            width: 60px;
        }

        .preA, nextA {
            width: 60px;
        }

        .pages a {
            display: inline-block;
            vertical-align: center;
            text-align: center;
            text-decoration: none;
            /*background-color: #ccc;*/
            height: 20px;
            color: black;

        }

        .pageText {
            float: left;
            margin-left: 50px;
        }

        .search {
            padding-top: 10px;
        }

        .search input {
            height: 30px;
            width: 100px;
            outline: none;
        }
    </style>
</head>

<body>
<div class="con">
    <form action="order.do" method="post" class="search">
        <input type="hidden" name="op" value="search">
        <input type="text" name="searchByName" placeholder="用户名"
               value="${"search".equals(sessionScope.op)?sessionScope.userAccount:""}">
        <%--        <input type="number" name="searchByCategoryId" placeholder="分类id">--%>
        <input type="submit" value="搜索" style="width: 50px;height: 30px;background-color: #7abaff">
        <input type="text" name="searchByName" placeholder="订单编号"
               value="${"search".equals(sessionScope.op)?sessionScope.searchByOrderNo:""}">
        <%--        <input type="number" name="searchByCategoryId" placeholder="分类id">--%>
        <input type="submit" value="搜索" style="width: 50px;height: 30px;background-color: #7abaff">
    </form>
    <table class="table" id="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">订单编号</th>
            <th scope="col">下单时间</th>
            <th scope="col">收货人</th>
            <th scope="col">电话</th>
            <th scope="col">地址</th>
            <th scope="col">金额</th>
            <th scope="col">支付方式</th>
            <th scope="col">支付时间</th>
            <th scope="col">支付状态</th>
            <th scope="col">订单状态</th>
            <th scope="col">操作</th>
        </tr>
        </thead>
        <tbody>
        <%--        <%for (Goods goods : goodslist) {%>--%>
        <c:forEach items="${sessionScope.orderList}" var="order">
            <tr>
                <th scope="row">
                        ${order.orderno}
                </th>
                <td>
                        ${order.ordertime}
                </td>
                <td>
                        ${order.accept}
                </td>
                <td>
                        ${order.telphone}
                </td>
                <td>
                        ${order.address}
                </td>
                <td>
                        ${order.money}
                </td>
                <td>
                        ${(1==order.paytype)?"支付宝":"微信"}
                </td>
                <td>
                        ${order.paytime}
                </td>
                <td>
                        ${(1==order.status)?"未支付":"已支付"}
                </td>
                <td>
                        ${(1==order.isdel)?"正常":"失效"}
                </td>
                <td>
                    <a href="goods_update.jsp?orderno=${order.orderno}" target="right">编辑</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<br>
<div class="foot">
    <div class="pages">
        <c:if test="${sessionScope.pageInfo.pageNum==1}">
            <a target="right" class="selePreA">上一页</a>
        </c:if>
        <c:if test="${sessionScope.pageInfo.pageNum!=1}">
            <a class="preA"
               href="order.do?page=${sessionScope.pageInfo.prePage}&op=${"search".equals(sessionScope.op)?"search":""}&searchByName=${sessionScope.searchByName}&req=display"
               target="right">上一页</a>
        </c:if>
        <c:forEach begin="1" end="${sessionScope.pageInfo.pages}" varStatus="pageVar">
            <c:if test="${sessionScope.pageInfo.pageNum==pageVar.count}">
                <a target="right" class="seleA">&nbsp${pageVar.count}&nbsp</a>
            </c:if>
            <c:if test="${sessionScope.pageInfo.pageNum!=pageVar.count}">
                <a href="order.do?page=${pageVar.count}&op=${"search".equals(sessionScope.op)?"search":""}&searchByName=${sessionScope.searchByName}&req=display"
                   target="right">&nbsp${pageVar.count}&nbsp</a>
            </c:if>
        </c:forEach>
        <c:if test="${sessionScope.pageInfo.pageNum==sessionScope.pageInfo.pages||sessionScope.pageInfo.pages==0}">
            <a target="right" class="seleNextA">下一页</a>
        </c:if>
        <c:if test="${sessionScope.pageInfo.pageNum != sessionScope.pageInfo.pages && sessionScope.pageInfo.pages!=0}">
            <a class="nextA"
               href="order.do?page=${sessionScope.pageInfo.nextPage}&op=${"search".equals(sessionScope.op)?"search":""}&searchByName=${sessionScope.searchByName}&req=display"
               target="right">下一页</a>
        </c:if>
    </div>
    <div class="pageText">
        <span>总共有&nbsp${sessionScope.pageInfo.pages}&nbsp页,</span>
        <span>第&nbsp${sessionScope.pageInfo.pages==0?0:sessionScope.pageInfo.pageNum}&nbsp页</span>
    </div>
</div>
</body>
</html>

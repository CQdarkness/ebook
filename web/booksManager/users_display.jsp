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
    <form action="goods.do" method="post" class="search">
        <input type="hidden" name="op" value="search">
        <input type="text" name="searchByName" placeholder="用户名"
               value="${"search".equals(sessionScope.op)?sessionScope.userAccount:""}">
        <%--        <input type="number" name="searchByCategoryId" placeholder="分类id">--%>
        <input type="submit" value="搜索" style="width: 50px;height: 30px;background-color: #7abaff">
    </form>
    <table class="table" id="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">id</th>
            <th scope="col">账户名</th>
            <th scope="col">密码</th>
            <th scope="col">邮箱</th>
            <th scope="col">头像</th>
            <th scope="col">积分</th>
            <th scope="col">注册时间</th>
            <th scope="col">注册码</th>
            <th scope="col">状态</th>
            <th scope="col">操作</th>
        </tr>
        </thead>
        <tbody>
        <%--        <%for (Goods goods : goodslist) {%>--%>
        <c:forEach items="${sessionScope.mallUsers}" var="mallUser">
            <tr>
                <th scope="row">
                        ${mallUser.id}
                </th>
                <td>
                        ${mallUser.account}
                </td>
                <td>
                        ${mallUser.password}
                </td>
                <td>
                        ${mallUser.email}
                </td>
                <td>
                        ${mallUser.avatar}
                </td>
                <td>
                        ${mallUser.score}
                </td>
                <td>
                        ${mallUser.regtime}
                </td>
                <td>
                        ${mallUser.vcode}
                </td>

                <td>
                        ${("y".equals(mallUser.status))?"正常":"失效"}
                </td>
                <td>
                    <a href="goods_update.jsp?id=${goods.id}" target="right">编辑</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<br>
<div class="foot">
<%--    <div class="pages">--%>
<%--        <c:if test="${sessionScope.pageInfo.pageNum==1}">--%>
<%--            <a target="right" class="selePreA">上一页</a>--%>
<%--        </c:if>--%>
<%--        <c:if test="${sessionScope.pageInfo.pageNum!=1}">--%>
<%--            <a class="preA"--%>
<%--               href="goods.do?page=${sessionScope.pageInfo.prePage}&op=${"search".equals(sessionScope.op)?"search":""}&searchByName=${sessionScope.searchByName}&req=display"--%>
<%--               target="right">上一页</a>--%>
<%--        </c:if>--%>
<%--        <c:forEach begin="1" end="${sessionScope.pageInfo.pages}" varStatus="pageVar">--%>
<%--            <c:if test="${sessionScope.pageInfo.pageNum==pageVar.count}">--%>
<%--                <a target="right" class="seleA">&nbsp${pageVar.count}&nbsp</a>--%>
<%--            </c:if>--%>
<%--            <c:if test="${sessionScope.pageInfo.pageNum!=pageVar.count}">--%>
<%--                <a href="goods.do?page=${pageVar.count}&op=${"search".equals(sessionScope.op)?"search":""}&searchByName=${sessionScope.searchByName}&req=display"--%>
<%--                   target="right">&nbsp${pageVar.count}&nbsp</a>--%>
<%--            </c:if>--%>
<%--        </c:forEach>--%>
<%--        <c:if test="${sessionScope.pageInfo.pageNum==sessionScope.pageInfo.pages||sessionScope.pageInfo.pages==0}">--%>
<%--            <a target="right" class="seleNextA">下一页</a>--%>
<%--        </c:if>--%>
<%--        <c:if test="${sessionScope.pageInfo.pageNum != sessionScope.pageInfo.pages && sessionScope.pageInfo.pages!=0}">--%>
<%--            <a class="nextA"--%>
<%--               href="goods.do?page=${sessionScope.pageInfo.nextPage}&op=${"search".equals(sessionScope.op)?"search":""}&searchByName=${sessionScope.searchByName}&req=display"--%>
<%--               target="right">下一页</a>--%>
<%--        </c:if>--%>
<%--    </div>--%>
<%--    <div class="pageText">--%>
<%--        <span>总共有&nbsp${sessionScope.pageInfo.pages}&nbsp页,</span>--%>
<%--        <span>第&nbsp${sessionScope.pageInfo.pages==0?0:sessionScope.pageInfo.pageNum}&nbsp页</span>--%>
<%--    </div>--%>
</div>
</body>
</html>

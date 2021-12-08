package com.dark.servlet;

import com.dark.model.Category;
import com.dark.model.Goods;
import com.dark.model.MallOrder;
import com.dark.model.MallUser;
import com.dark.service.CategoryService;
import com.dark.service.GoodsService;
import com.dark.service.MallOrderService;
import com.dark.service.MallUserService;
import com.dark.service.impl.CategoryServiceImpl;
import com.dark.service.impl.GoodsServiceImpl;
import com.dark.service.impl.MallOrderServiceImpl;
import com.dark.service.impl.MallUserServiceImpl;
import com.github.pagehelper.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/booksManager/order.do")
public class OrderJSPServlet extends HttpServlet {
    GoodsService goodsService = new GoodsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求字符集
        req.setCharacterEncoding("utf-8");
        //页面展示相关
        PageInfo<MallOrder> pageInfou=null;
        PageInfo<MallOrder> pageInfo=null;
        List<MallOrder> orderList=null;
        MallOrderService mallOrderService=new MallOrderServiceImpl();
        MallUserService mallUserService=new MallUserServiceImpl();
        List<MallUser> mallUsers = mallUserService.findAllUsers();
        String pageNum = req.getParameter("page");
        Integer pageSize = 5;
        if (pageNum == null) {
            pageNum = "1";
        }
        pageInfo=mallOrderService.findAllByPage(Integer.parseInt(pageNum),pageSize);
        orderList=pageInfo.getList();
        //存入session中
        req.getSession().setAttribute("mallUsers",mallUsers);
        req.getSession().setAttribute("orderList",orderList);
        req.getSession().setAttribute("pageInfo",pageInfo);
        req.getSession().setAttribute("pageNum",pageNum);
        req.getSession().setAttribute("pageSize",pageSize);

        //处理表单请求，判定表单类型
        String op = req.getParameter("op");
        String reqA = req.getParameter("req");
        req.getSession().setAttribute("op",op);
        //更新订单请求
        if ("update".equals(op)) {
            //获取表单数据
            String orderno=req.getParameter("orderno");
            String isdel = req.getParameter("isdel");
            //非空判定
            if ( isdel == null || "".equals(isdel)||orderno == null || "".equals(orderno)) {
                resp.sendRedirect("order_update.jsp");
                return;
            }
            MallOrder mallOrderById = mallOrderService.findMallOrderById(orderno);
            //封装对象
            mallOrderById.setIsdel(Integer.parseInt(isdel));
            //添加 并重定向
            mallOrderService.updateMallOrder(mallOrderById);
            resp.sendRedirect("goods.do?req=display");
            //删除商品请求
        } else if("search".equals(op)) {
            MallOrder mallOrderByOrderNo=null;
            MallUser userByAccount=null;
            String account = req.getParameter("UserAccount");
            if(!"".equals(account)&&account!=null){
                userByAccount = mallUserService.findUserByAccount(account);
            }
            Integer searchByUserId = userByAccount.getId();
            String searchByOrderNo = req.getParameter("searchByOrderNo");
            if("".equals(searchByOrderNo)||searchByOrderNo==null){
                pageInfo =mallOrderService.findMallOrderByUserIdPage(searchByUserId,
                        Integer.parseInt(pageNum), pageSize);
                pageInfo.getList();
            }else{
                mallOrderByOrderNo=mallOrderService.findMallOrderById(searchByOrderNo);
            }

            //存入Session中
            req.getSession().setAttribute("pageInfo",pageInfo);
            req.getSession().setAttribute("mallOrderByOrderNo",mallOrderByOrderNo);
            req.getSession().setAttribute("userAccount",account);
            req.getSession().setAttribute("searchByOrderNo",searchByOrderNo);
            resp.sendRedirect("goods_display.jsp");
        }else if("user".equals(op)){
            resp.sendRedirect("users_display.jsp");
        }
        else{
            resp.sendRedirect("order_display.jsp");
        }
    }
}


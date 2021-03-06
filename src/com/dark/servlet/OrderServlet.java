package com.dark.servlet;

import com.dark.model.MallOrder;
import com.dark.model.Message;
import com.dark.service.MallOrderService;
import com.dark.service.impl.MallOrderServiceImpl;
import com.dark.util.JsonWriter;
import com.dark.util.Tools;
import com.github.pagehelper.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@WebServlet("/order.do")
public class OrderServlet extends BaseServlet {
    private MallOrderService mallOrderService=new MallOrderServiceImpl();
    public void addOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message = new Message();
        MallOrder mallOrder = new MallOrder();
        //获取参数
        String userid = req.getParameter("userid");
        String accept = req.getParameter("accept");
        String telphone = req.getParameter("telphone");
        String address = req.getParameter("address");
        String money = req.getParameter("money");
        String paytype = req.getParameter("paytype");
        String orderno=req.getParameter("orderno");
        //非空判定
        if (address == null || "".equals(address) || accept == null || "".equals(accept) || telphone == null || "".equals(telphone)
                || money == null || "".equals(money) || paytype == null || "".equals(paytype) || userid == null || "".equals(userid)) {
            message.setResult("false");
            message.setCode(Tools.DATANULL);
            JsonWriter.write(message, resp);
            return;
        }

        //封装
        mallOrder.setAddress(address);
        mallOrder.setAccept(accept);
        mallOrder.setOrderno(orderno);
        mallOrder.setOrdertime(new Date());
        mallOrder.setTelphone(telphone);
        mallOrder.setUserid(Integer.parseInt(userid));
        mallOrder.setIsdel(1);
        mallOrder.setPaytype(Integer.parseInt(paytype));
        mallOrder.setMoney(new BigDecimal(money));
        mallOrder.setStatus(1);
        //插入
        if(mallOrderService.insertMallOrder(mallOrder)!=0){
            message.setResult("true");
            JsonWriter.write(message,resp);
        }else{
            message.setResult("false");
            JsonWriter.write(message,resp);
        }
    }

    public void updateOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void displayOrderByUserId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message=new Message();
        String userid = req.getParameter("userid");
        List<MallOrder> mallOrderByUserId = mallOrderService.findMallOrderByUserId(Integer.parseInt(userid));
        message.setData(mallOrderByUserId);
        JsonWriter.write(message,resp);
    }
    public void displayOrderByUserIdPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message=new Message();
        Integer pageNum=1;
        Integer pageSize=4;
        String userid = req.getParameter("userid");
        String pageNums = req.getParameter("pageNums");
        if(pageNums!=null||"".equals(pageNums)){
            pageNum=Integer.parseInt(pageNums);
        }
        PageInfo<MallOrder> pageInfo = mallOrderService.findMallOrderByUserIdPage(Integer.parseInt(userid),pageNum,pageSize);
        message.setData(pageInfo.getList());
        message.setSecondData(pageInfo);
        JsonWriter.write(message,resp);
    }
    public void displayOrderById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message=new Message();
        String orderno = req.getParameter("orderno");
        MallOrder mallOrderById = mallOrderService.findMallOrderById(orderno);
        message.setData(mallOrderById);
        JsonWriter.write(message,resp);
    }
}

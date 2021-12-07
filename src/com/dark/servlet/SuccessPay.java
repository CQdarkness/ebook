package com.dark.servlet;

import com.dark.model.MallOrder;
import com.dark.service.MallOrderService;
import com.dark.service.impl.MallOrderServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
@WebServlet("/paySuccess.do")
public class SuccessPay extends BaseServlet{
    private MallOrderService mallOrderService=new MallOrderServiceImpl();
    public String paied(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String orderNo = req.getParameter("orderNo");
        MallOrder mallOrderById = mallOrderService.findMallOrderById(orderNo);
        mallOrderById.setStatus(0);
        mallOrderById.setPaytime(new Date());
        if(mallOrderService.updateMallOrder(mallOrderById)!=0){
            return "r:/myOrders.html";
        }else{
            return "r:/index.html";
        }
    }
}

package com.dark.servlet;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayOpenPublicTemplateMessageIndustryModifyRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayOpenPublicTemplateMessageIndustryModifyResponse;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.dark.util.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet("/pay")
public class AliPayServlet extends BaseServlet {
    public void pay(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", Tools.APP_ID, Tools.APP_PRIVATE_KEY, "json", "UTF-8", Tools.ALIPAY_PUBLIC_KEY, "RSA2");
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setNotifyUrl("");
        request.setReturnUrl("");
        JSONObject bizContent = new JSONObject();
        //获取参数
        String orderno = req.getParameter("orderNo");
        String money = req.getParameter("money");
        String form="{"  +
                "    \"out_trade_no\":\""+orderno+"\"  ,"  +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\","  +
                "    \"total_amount\":\""+money+"\","  +
                "    \"subject\":\"图书\""  +
                "  }";
        System.out.println(form);
        request.setBizContent(form); //填充业务参数
        AlipayTradePagePayResponse response = alipayClient.pageExecute(request);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(response.getBody());
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }


}

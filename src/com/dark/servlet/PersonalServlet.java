package com.dark.servlet;

import com.dark.model.Address;
import com.dark.model.Message;
import com.dark.service.AddressService;
import com.dark.service.impl.AddressServiceImpl;
import com.dark.util.JsonWriter;
import com.dark.util.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/personal.do")
public class PersonalServlet extends BaseServlet {
    private AddressService addressService = new AddressServiceImpl();

    public void addAddress(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message = new Message();
        Address address = new Address();
        //获取参数
        String userid = req.getParameter("userid");
        String accept = req.getParameter("accept");
        String telphone = req.getParameter("telphone");
        String province = req.getParameter("province");
        String city = req.getParameter("city");
        String area = req.getParameter("area");
        String address2 = req.getParameter("address");
        String type = req.getParameter("type");
        //非空判定
        if(userid==null||"".equals(userid)||accept==null||"".equals(accept)||telphone==null||"".equals(telphone)
                ||province==null||"".equals(province)||city==null||"".equals(city)||area==null||"".equals(area)
                ||address2==null||"".equals(address2)||type==null||"".equals(type)){
            message.setResult("false");
            message.setCode(Tools.DATANULL);
            JsonWriter.write(message,resp);
            return;
        }
        //封装
        address.setAddress(address2);
        address.setAccept(accept);
        address.setArea(area);
        address.setCity(city);
        address.setProvince(province);
        address.setTelphone(telphone);
        address.setType(type);
        address.setUserid(Integer.parseInt(userid));
        //存入数据库
        if (addressService.insertAddress(address) != 0) {
            message.setResult("true");
            JsonWriter.write(message, resp);
        } else {
            message.setResult("false");
            message.setCode(Tools.SQLERROR);
            JsonWriter.write(message, resp);
        }
    }

    public void updateAddress(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message = new Message();
        Address address = new Address();
        //获取参数
        String userid = req.getParameter("userid");
        String accept = req.getParameter("accept");
        String telphone = req.getParameter("telphone");
        String province = req.getParameter("province");
        String city = req.getParameter("city");
        String area = req.getParameter("area");
        String address2 = req.getParameter("address");
        String type = req.getParameter("type");
        //非空判定
        if(userid==null||"".equals(userid)||accept==null||"".equals(accept)||telphone==null||"".equals(telphone)
                ||province==null||"".equals(province)||city==null||"".equals(city)||area==null||"".equals(area)
                ||address2==null||"".equals(address2)||type==null||"".equals(type)){
            message.setResult("false");
            message.setCode(Tools.DATANULL);
            JsonWriter.write(message,resp);
            return;
        }
        //封装
        address.setAddress(address2);
        address.setAccept(accept);
        address.setArea(area);
        address.setCity(city);
        address.setProvince(province);
        address.setTelphone(telphone);
        address.setType(type);
        address.setUserid(Integer.parseInt(userid));
        //存入数据库
        if (addressService.updateAddress(address) != 0) {
            message.setResult("true");
            JsonWriter.write(message, resp);
        } else {
            message.setResult("false");
            message.setCode(Tools.SQLERROR);
            JsonWriter.write(message, resp);
        }
    }

    public void displayAddress(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message=new Message();
        //获取USERID
        String userid = req.getParameter("userid");
        if(userid==null||"".equals(userid)){
            message.setResult("false");
            message.setCode(Tools.DATANULL);
            JsonWriter.write(message,resp);
            return;
        }
        List<Address> addressByUserId = addressService.findAddressByUserId(Integer.parseInt(userid));
        message.setResult("true");
        message.setData(addressByUserId);
        JsonWriter.write(message,resp);
    }
}

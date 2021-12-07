package com.dark.servlet;

import com.dark.model.Goods;
import com.dark.model.MallCart;
import com.dark.model.Message;
import com.dark.service.GoodsService;
import com.dark.service.MallCartService;
import com.dark.service.MallUserService;
import com.dark.service.impl.GoodsServiceImpl;
import com.dark.service.impl.MallCartServiceImpl;
import com.dark.service.impl.MallUserServiceImpl;
import com.dark.util.JsonWriter;
import com.dark.util.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cart.do")
public class CartServlet extends BaseServlet {
    private MallCartService mallCartService = new MallCartServiceImpl();

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message = new Message();
        MallCart mallCart = new MallCart();
        //获取信息
        String goodsid = req.getParameter("goodsid");
        String userid = req.getParameter("userid");
        String nums = req.getParameter("nums");
        String selected = req.getParameter("selected");
        //非空判定
        if ("".equals(userid) || userid == null || "".equals(goodsid) || goodsid == null
                || "".equals(nums) || nums == null || "".equals(selected) || selected == null) {
            message.setResult("false");
            message.setCode(Tools.DATANULL);
            JsonWriter.write(message, resp);
            return;
        }
        //封装
        //判定商品是否重复
        MallCart mallCart1 = mallCartService.findMallCartByGoodsId(Integer.parseInt(goodsid));
        if (mallCart1 != null) {
            mallCart1.setNums(Integer.parseInt(nums) + mallCart1.getNums());
            mallCart1.setGoodsid(Integer.parseInt(goodsid));
            //写入数据库
            if (mallCartService.updateMallCart(mallCart1) != 0) {
                message.setResult("true");
                JsonWriter.write(message, resp);
            } else {
                message.setResult("false");
                message.setCode(Tools.SQLERROR);
                JsonWriter.write(message, resp);
            }
        } else {
            mallCart.setNums(Integer.parseInt(nums));
            mallCart.setSelected(selected);
            mallCart.setUserid(Integer.parseInt(userid));
            mallCart.setGoodsid(Integer.parseInt(goodsid));
            //写入数据库
            if (mallCartService.insertMallCart(mallCart) != 0) {
                message.setResult("true");
                JsonWriter.write(message, resp);
            } else {
                message.setResult("false");
                message.setCode(Tools.SQLERROR);
                JsonWriter.write(message, resp);
            }
        }
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message = new Message();
        MallCart mallCart = new MallCart();
        //获取信息
        String userid = req.getParameter("userid");
        String goodsid = req.getParameter("goodsid");
        String nums = req.getParameter("nums");
        String selected = req.getParameter("selected");
        //非空判定
        if ("".equals(userid) || userid == null || "".equals(goodsid) || goodsid == null
                || "".equals(nums) || nums == null || "".equals(selected) || selected == null) {
            message.setResult("false");
            message.setCode(Tools.DATANULL);
            JsonWriter.write(message, resp);
            return;
        }
        //封装
        mallCart.setSelected(selected);
        mallCart.setNums(Integer.parseInt(nums));
        mallCart.setUserid(Integer.parseInt(userid));
        mallCart.setGoodsid(Integer.parseInt(goodsid));
        //写入数据库
        if (mallCartService.updateMallCart(mallCart) != 0) {
            message.setResult("true");
            JsonWriter.write(message, resp);
        } else {
            message.setResult("false");
            message.setCode(Tools.SQLERROR);
            JsonWriter.write(message, resp);
        }
    }

    public void display(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message = new Message();
        List<MallCart> allMallCart = mallCartService.findAllMallCart();
        message.setData(allMallCart);
        JsonWriter.write(message, resp);
    }

    public void getCartByUserId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message = new Message();
        //获取参数
        String userid = req.getParameter("userid");
        List<MallCart> mallCartByUserId = mallCartService.findMallCartByUserId(Integer.parseInt(userid));
        message.setData(mallCartByUserId);
        JsonWriter.write(message, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message = new Message();
        //获取参数
        String gid = req.getParameter("gid");
        if (mallCartService.deleteByGoodsId(Integer.parseInt(gid)) != 0) {
            message.setResult("true");
            JsonWriter.write(message, resp);
        } else {
            message.setResult("false");
            JsonWriter.write(message, resp);
        }
    }
}

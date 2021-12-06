package com.dark.servlet;

import com.dark.model.Category;
import com.dark.model.Goods;
import com.dark.model.Message;
import com.dark.service.GoodsService;
import com.dark.service.impl.GoodsServiceImpl;
import com.dark.util.JsonWriter;
import com.github.pagehelper.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@WebServlet("/goods.do")
public class GoodsServlet extends BaseServlet {
    private GoodsService goodsService = new GoodsServiceImpl();
    private PageInfo<Goods> pageInfo;
    private List<Goods> goodsList;
    private Integer pageSize = 5;
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取表单数据
        String name = req.getParameter("name");
        String goodsno = req.getParameter("goodsno");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        String pubtime = req.getParameter("pubtime");
        String categoryid = req.getParameter("categoryid");
        String description = req.getParameter("description");
        String image = req.getParameter("image");
        String stock = req.getParameter("stock");
        String marketprice = req.getParameter("marketprice");
        String salesprice = req.getParameter("salesprice");
        String salenums = req.getParameter("salenums");
        String newest = req.getParameter("newest");
        String hot = req.getParameter("hot");
        String status = req.getParameter("status");
        //非空判定
        if (name == null || "".equals(name) || goodsno == null || "".equals(goodsno) || author == null || "".equals(author)
                || publisher == null || "".equals(publisher) || pubtime == null || "".equals(pubtime) || categoryid == null || "".equals(categoryid)
                || description == null || "".equals(description) || image == null || "".equals(image) || stock == null || "".equals(stock)
                || marketprice == null || "".equals(marketprice) || salesprice == null || "".equals(salesprice)
                || salenums == null || "".equals(salenums)) {
            resp.sendRedirect("goods_add.jsp");
            return;
        }
        //封装对象
        Goods goods = new Goods();
        goods.setName(name);
        goods.setGoodsno(goodsno);
        goods.setAuthor(author);
        goods.setPublisher(publisher);
        goods.setPubtime(pubtime);
        goods.setCategoryid(Integer.parseInt(categoryid));
        goods.setDescription(description);
        goods.setImage(image);
        goods.setStock(Integer.parseInt(stock));
        goods.setMarketprice(new BigDecimal(marketprice));
        goods.setSalesprice(new BigDecimal(salesprice));
        goods.setUptime(new Date());
        goods.setSalenums(Integer.parseInt(salenums));
        if (newest == null)
            newest = "N";
        goods.setNewest(newest);
        if (hot == null)
            hot = "N";
        goods.setHot(hot);
        if (status == null)
            status = "N";
        goods.setStatus(status);
        //添加 并重定向
        goodsService.insertGoods(goods);
//        resp.sendRedirect("goods.do?req=display");
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取表单数据
        String updateId = req.getParameter("updateId");
        String name = req.getParameter("name");
        String goodsno = req.getParameter("goodsno");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        String pubtime = req.getParameter("pubtime");
        String categoryid = req.getParameter("categoryid");
        String description = req.getParameter("description");
        String image = req.getParameter("image");
        String stock = req.getParameter("stock");
        String marketprice = req.getParameter("marketprice");
        String salesprice = req.getParameter("salesprice");
        String salenums = req.getParameter("salenums");
        String newest = req.getParameter("newest");
        String hot = req.getParameter("hot");
        String status = req.getParameter("status");
        //非空判定
        if (name == null || "".equals(name) || goodsno == null || "".equals(goodsno) || author == null || "".equals(author)
                || publisher == null || "".equals(publisher) || pubtime == null || "".equals(pubtime) || categoryid == null || "".equals(categoryid)
                || description == null || "".equals(description) || image == null || "".equals(image) || stock == null || "".equals(stock)
                || marketprice == null || "".equals(marketprice) || salesprice == null || "".equals(salesprice)
                || salenums == null || "".equals(salenums)) {
//                resp.sendRedirect("goods_update.jsp");
            Message message = new Message();
            message.setResult("false");
            JsonWriter.write(message, resp);
            return;
        }
        //封装对象
        Goods goods = new Goods();
        goods.setId(Integer.parseInt(updateId));
        goods.setName(name);
        goods.setGoodsno(goodsno);
        goods.setAuthor(author);
        goods.setPublisher(publisher);
        goods.setPubtime(pubtime);
        goods.setCategoryid(Integer.parseInt(categoryid));
        goods.setDescription(description);
        goods.setImage(image);
        goods.setStock(Integer.parseInt(stock));
        goods.setMarketprice(new BigDecimal(marketprice));
        goods.setSalesprice(new BigDecimal(salesprice));
        goods.setUptime(new Date());
        goods.setSalenums(Integer.parseInt(salenums));
        if (newest == null)
            newest = "N";
        goods.setNewest(newest);
        if (hot == null)
            hot = "N";
        goods.setHot(hot);
        if (status == null)
            status = "N";
        goods.setStatus(status);
        //添加 并重定向
        Message message = new Message();
        message.setResult("true");
        JsonWriter.write(message, resp);
        goodsService.updateGoods(goods);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteId = req.getParameter("deleteId");
        goodsService.deleteGoodsById(Integer.parseInt(deleteId));
//        resp.sendRedirect("goods.do?req=display");
    }

    public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchByName = req.getParameter("searchByName");
        String searchByCategoryId = req.getParameter("searchByCategoryId");
        String pageNum = req.getParameter("page");
        if (pageNum == null) {
            pageNum = "1";
        }
        if ("".equals(searchByCategoryId)) {
            searchByCategoryId = null;
        }
        if ("".equals(searchByName)) {
            searchByName = null;
        }
        Integer categoryId = null;
        if (searchByCategoryId != null) {
            categoryId = Integer.parseInt(searchByCategoryId);
        }
        pageInfo = goodsService.searchGoodsByNameAndCategoryId(searchByName, categoryId
                , Integer.parseInt(pageNum), pageSize);
        goodsList = pageInfo.getList();
        //存入Message中
        Message message = new Message(goodsList);
        message.setPageInfo(pageInfo);
        //使用工具类写出给ajax
        JsonWriter.write(message, resp);
    }

    public void display(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("page");
        if ("0".equals(pageNum)||pageNum==null) {
            pageNum = "1";
        }
        pageInfo = goodsService.findAllGoods(Integer.parseInt(pageNum), pageSize);
        goodsList = pageInfo.getList();
        //存入Message中
        Message message = new Message(goodsList);
        message.setPageInfo(pageInfo);
        //使用工具类写出给ajax
        JsonWriter.write(message, resp);
    }

    public void getGoodsById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goodsId = req.getParameter("goodsId");
        Goods goods = goodsService.findGoodsById(Integer.parseInt(goodsId));
        //存入Message中
        Message message = new Message(goods);
        //使用工具类写出给ajax
        JsonWriter.write(message, resp);
    }

}

package com.dark.servlet;

import com.github.pagehelper.PageInfo;
import com.dark.model.Category;
import com.dark.model.Goods;
import com.dark.service.CategoryService;
import com.dark.service.GoodsService;
import com.dark.service.impl.CategoryServiceImpl;
import com.dark.service.impl.GoodsServiceImpl;

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

@WebServlet("/booksManager/goods.do")
public class GoodsJSPServlet extends HttpServlet {
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
        PageInfo<Goods> pageInfo=null;
        List<Goods> goodsList=null;
        GoodsService goodsService = new GoodsServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> allCategory = categoryService.findAllCategory();
        String pageNum = req.getParameter("page");
        Integer pageSize = 5;
        if (pageNum == null) {
            pageNum = "1";
        }
        //存入session中
        req.getSession().setAttribute("allCategory",allCategory);
        req.getSession().setAttribute("pageNum",pageNum);
        req.getSession().setAttribute("pageSize",pageSize);

        //处理表单请求，判定表单类型
        String op = req.getParameter("op");
        String reqA = req.getParameter("req");
        req.getSession().setAttribute("op",op);
        //添加商品请求
        if ("add".equals(op)) {
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
            String uptime = req.getParameter("uptime");
            String downtime = req.getParameter("downtime");
            String salenums = req.getParameter("salenums");
            String newest = req.getParameter("newest");
            String hot = req.getParameter("hot");
            String status = req.getParameter("status");
            //非空判定
            if (name == null || "".equals(name) || goodsno == null || "".equals(goodsno) || author == null || "".equals(author)
                    || publisher == null || "".equals(publisher) || pubtime == null || "".equals(pubtime) || categoryid == null || "".equals(categoryid)
                    || description == null || "".equals(description) || image == null || "".equals(image) || stock == null || "".equals(stock)
                    || marketprice == null || "".equals(marketprice) || salesprice == null || "".equals(salesprice) || uptime == null || "".equals(uptime)
                    || salenums == null || "".equals(salenums)) {
                resp.sendRedirect("goods_add.jsp");
                return;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date uptimeDate=null;
            Date downtimeDate=null;
            if("".equals(downtime)){
                downtime=null;
            }
            try {
                uptimeDate =simpleDateFormat.parse(uptime);
                if(downtime!=null){
                    downtimeDate=simpleDateFormat.parse(downtime);}else{
                    downtimeDate=null;
                }
            } catch (ParseException e) {
                e.printStackTrace();
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
            goods.setUptime(uptimeDate);
            goods.setDowntime(downtimeDate);
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
            resp.sendRedirect("goods.do?req=display");
            //更新商品请求
        } else if ("update".equals(op)) {
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
            String uptime = req.getParameter("uptime");
            String downtime = req.getParameter("downtime");
            String salenums = req.getParameter("salenums");
            String newest = req.getParameter("newest");
            String hot = req.getParameter("hot");
            String status = req.getParameter("status");
            //非空判定
            if (name == null || "".equals(name) || goodsno == null || "".equals(goodsno) || author == null || "".equals(author)
                    || publisher == null || "".equals(publisher) || pubtime == null || "".equals(pubtime) || categoryid == null || "".equals(categoryid)
                    || description == null || "".equals(description) || image == null || "".equals(image) || stock == null || "".equals(stock)
                    || marketprice == null || "".equals(marketprice) || salesprice == null || "".equals(salesprice) || uptime == null || "".equals(uptime)
                    || salenums == null || "".equals(salenums)) {
                resp.sendRedirect("goods_update.jsp");
                return;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date uptimeDate=null;
            Date downtimeDate=null;
            if("".equals(downtime)){
                downtime=null;
            }
            try {
                uptimeDate =simpleDateFormat.parse(uptime);
                if(downtime!=null){
                    downtimeDate=simpleDateFormat.parse(downtime);}else{
                    downtimeDate=null;
                }
            } catch (ParseException e) {
                e.printStackTrace();
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
            goods.setUptime(uptimeDate);
            goods.setDowntime(downtimeDate);
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
            goodsService.updateGoods(goods);
            resp.sendRedirect("goods.do?req=display");
            //删除商品请求
        } else if("delete".equals(op)){
            String deleteId = req.getParameter("deleteId");
            goodsService.deleteGoodsById(Integer.parseInt(deleteId));
            resp.sendRedirect("goods.do?req=display");
        }else if("search".equals(op)) {
            String searchByName = req.getParameter("searchByName");
            String searchByCategoryId = req.getParameter("searchByCategoryId");
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
            //存入Session中
            req.getSession().setAttribute("pageInfo",pageInfo);
            req.getSession().setAttribute("goodsList",goodsList);
            req.getSession().setAttribute("searchByName",searchByName);
            req.getSession().setAttribute("searchByCategoryId",searchByCategoryId);
            resp.sendRedirect("goods_display.jsp");
        }else if("display".equals(reqA)){
            pageInfo = goodsService.findAllGoods(Integer.parseInt(pageNum), pageSize);
            goodsList = pageInfo.getList();
            //存入Session中
            req.getSession().setAttribute("pageInfo",pageInfo);
            req.getSession().setAttribute("goodsList",goodsList);
            resp.sendRedirect("goods_display.jsp");


        }else{
            resp.sendRedirect("booksManager.jsp");
        }
    }
}


package com.dark.test;

import com.dark.dao.MallOrderDao;
import com.dark.dao.impl.MallOrderDaoImpl;
import com.dark.model.MallCart;
import com.dark.model.MallOrder;
import com.dark.service.MallCartService;
import com.dark.service.impl.MallCartServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
//        MallCartService mallCartService=new MallCartServiceImpl();
//        MallCart mallCart=new MallCart();
//        mallCart.setGoodsid(3);
//        mallCart.setUserid(1);
//        mallCart.setNums(55);
//        mallCart.setSelected("y");
////        System.out.println("行数"+mallCartService.insertMallCart(mallCart));
//
//        System.out.println(mallCartService.findAllMallCart());
//        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));


        MallOrderDao mallOrderService=new MallOrderDaoImpl();
        MallOrder mallOrderById = mallOrderService.findMallOrderById("BKM203307135949189");
        mallOrderById.setStatus(0);
        mallOrderById.setPaytime(new Date());
        System.out.println(mallOrderService.updateMallOrder(mallOrderById));
    }
}

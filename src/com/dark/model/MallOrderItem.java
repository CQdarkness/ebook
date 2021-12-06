package com.dark.model;

import java.io.PrintWriter;
import java.io.Serializable;
import java.math.BigDecimal;

public class MallOrderItem implements Serializable {
    private Integer id;
    private Integer orderid;
    private Integer goodsid;
    private Integer nums;
    private BigDecimal price;

    public MallOrderItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

package com.dark.model;

import java.io.Serializable;
import java.util.List;

public class OrderManger implements Serializable {
    private List<MallUser>  mallUserList;
    private List<MallOrder> mallOrderList;

    public OrderManger() {
    }

    public List<MallUser> getMallUserList() {
        return mallUserList;
    }

    public void setMallUserList(List<MallUser> mallUserList) {
        this.mallUserList = mallUserList;
    }

    public List<MallOrder> getMallOrderList() {
        return mallOrderList;
    }

    public void setMallOrderList(List<MallOrder> mallOrderList) {
        this.mallOrderList = mallOrderList;
    }
}

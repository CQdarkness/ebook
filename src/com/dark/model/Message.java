package com.dark.model;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;

public class Message implements Serializable {
    private Integer code;
    private String result;
    private Object data;
    private PageInfo pageInfo;
    private String valicode;
    private Object secondData;

    public Message() {
    }
    public Message(Object data) {
        this.data=data;
    }

    public Object getSecondData() {
        return secondData;
    }

    public void setSecondData(Object secondData) {
        this.secondData = secondData;
    }

    public String getValicode() {
        return valicode;
    }

    public void setValicode(String valicode) {
        this.valicode = valicode;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}

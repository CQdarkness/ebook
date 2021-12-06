package com.dark.model;

import java.io.Serializable;

public class Category implements Serializable {
    private Integer id;
    private String name;
    private String status;
    private String navable;
    private Integer sort;

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNavable() {
        return navable;
    }

    public void setNavable(String navable) {
        this.navable = navable;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}

package com.dark.model;

import java.io.Serializable;

public class MallRegion implements Serializable {
    private Integer id;
    private String  name;
    private Integer pid;

    public MallRegion() {
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}

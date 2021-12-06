package com.dark.model;

import java.io.Serializable;
import java.util.Date;

public class MallUser implements Serializable {
    private Integer id;
    private String account;
    private String password;
    private String email;
    private String avatar;
    private Integer score;
    private Date regtime;
    private String vcode;
    private String status;

    public MallUser() {
    }

    public MallUser(String account, String password
            , String email, String avatar, Integer score, Date regtime
            , String vcode, String status ) {
        this.account = account;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.score = score;
        this.regtime = regtime;
        this.vcode = vcode;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MallUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", score=" + score +
                ", regtime=" + regtime +
                ", vcode=" + vcode +
                ", status=" + status +
                '}';
    }
}

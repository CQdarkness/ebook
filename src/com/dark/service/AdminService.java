package com.dark.service;

import com.dark.model.Admin;

public interface AdminService {
    /**
     * 登录功能
     * @param account 用户名
     * @param password 密码
     */
    public Admin login(String account, String password);
}

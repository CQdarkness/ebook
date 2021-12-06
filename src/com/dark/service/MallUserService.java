package com.dark.service;

import com.dark.model.MallUser;

public interface MallUserService {
    //登录业务
    MallUser login(String account, String psw);

    //注册业务
    void register(MallUser mallUser);

    //ajax查询
    MallUser findUserByAccount(String account);
    //邮箱验证
    MallUser findUserByEmail(String email);
    //更新用户信息
    Integer updateUser(MallUser mallUser);
}

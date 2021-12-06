package com.dark.service.impl;

import com.dark.dao.MallUserDao;
import com.dark.dao.impl.MallUserDaoImpl;
import com.dark.excption.UserException;
import com.dark.model.MallUser;
import com.dark.service.MallUserService;

public class MallUserServiceImpl implements MallUserService {
    private MallUserDao mallUserDao=new MallUserDaoImpl();
    @Override
    public MallUser login(String account, String psw) {
            MallUser mallUser=null;
            try{
               mallUser= mallUserDao.loginByAccountAndPassword(account, psw);
            }catch (Exception e) {
                e.printStackTrace();
                throw new UserException("登录失败！");
            }
            return mallUser;
    }

    @Override
    public void register(MallUser mallUser) {
        try{
            mallUserDao.insertMallUser(mallUser);
        }catch (Exception e) {
            e.printStackTrace();
            throw new UserException("注册失败！");
        }
    }

    @Override
    public MallUser findUserByAccount(String account) {
            return mallUserDao.findUserByAccount(account);
    }

    @Override
    public MallUser findUserByEmail(String email) {
        return mallUserDao.findUserByEmail(email);
    }

    @Override
    public Integer updateUser(MallUser mallUser) {
        return mallUserDao.updateUser(mallUser);
    }
}

package com.dark.service.impl;

import com.dark.dao.AdminDao;
import com.dark.dao.impl.AdminDaoImpl;
import com.dark.model.Admin;
import com.dark.service.AdminService;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao=new AdminDaoImpl();
    @Override
    public Admin login(String account, String password) {
        Admin adminByAccount = adminDao.findAdminByAccount(account);
        if(adminByAccount !=null
                && adminByAccount.getPassword().equals(password)
                && adminByAccount.getStatus().equals("y")){
            return adminByAccount;
        }
        return null;
    }
}

package com.dark.dao.impl;

import com.dark.dao.AdminDao;
import com.dark.mappers.AdminMapper;
import com.dark.model.Admin;
import com.dark.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin findAdminByAccount(String account) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        Admin adminByAccount = mapper.findAdminByAccount(account);
        MybatisUtil.closeSqlSession();
        return adminByAccount;
    }
}

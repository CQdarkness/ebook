package com.dark.dao.impl;

import com.dark.dao.MallUserDao;
import com.dark.mappers.MallUserMapper;
import com.dark.model.MallUser;
import com.dark.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class MallUserDaoImpl implements MallUserDao {

    @Override
    public List<MallUser> findAllUsers() {
        //获取Sqlsession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //反射获取对应接口
        MallUserMapper mapper = sqlSession.getMapper(MallUserMapper.class);
        //调用接口方法实现查询
        List<MallUser> allUsers = mapper.findAllUsers();
        //关闭sqlsession
        MybatisUtil.closeSqlSession();
        return allUsers;
    }

    @Override
    public MallUser findMallUserById(Integer id) {
        //获取Sqlsession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //反射获取对应接口
        MallUserMapper mapper = sqlSession.getMapper(MallUserMapper.class);
        //调用接口方法实现查询
        MallUser mallUserById = mapper.findMallUserById(id);
        //关闭sqlsession
        MybatisUtil.closeSqlSession();
        return mallUserById;
    }

    @Override
    public int insertMallUser(MallUser mallUser) {
        //获取Sqlsession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //反射获取对应接口
        MallUserMapper mapper = sqlSession.getMapper(MallUserMapper.class);
        //调用接口方法实现插入
        int i = mapper.insertMallUser(mallUser);
        //提交事务
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
        return i;
    }

    @Override
    public MallUser findUserByAccount(String account) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        MallUserMapper mapper = sqlSession.getMapper(MallUserMapper.class);
        MallUser mallUser = mapper.findUserByAccount(account);
        MybatisUtil.closeSqlSession();
        return mallUser;
    }

    @Override
    public MallUser findUserByEmail(String email) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        MallUserMapper mapper = sqlSession.getMapper(MallUserMapper.class);
        MallUser mallUser = mapper.findUserByEmail(email);
        MybatisUtil.closeSqlSession();
        return mallUser;
    }

    @Override
    public Integer updateUser(MallUser mallUser) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        MallUserMapper mapper = sqlSession.getMapper(MallUserMapper.class);
        int r = mapper.updateUser(mallUser);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
        return r;
    }

    @Override
    public MallUser loginByAccountAndPassword(String account,String password) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        MallUserMapper mapper = sqlSession.getMapper(MallUserMapper.class);
        MallUser mallUser = mapper.loginByAccountAndPassword(account,password);
        MybatisUtil.closeSqlSession();
        return mallUser;
    }

}

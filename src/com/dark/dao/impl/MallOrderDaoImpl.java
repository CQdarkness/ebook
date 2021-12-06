package com.dark.dao.impl;

import com.dark.dao.MallOrderDao;
import com.dark.mappers.MallOrderMapper;
import com.dark.model.MallOrder;
import com.dark.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MallOrderDaoImpl implements MallOrderDao {
    @Override
    public MallOrder findMallOrderById(Integer id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        MallOrderMapper mapper = sqlSession.getMapper(MallOrderMapper.class);
        MallOrder mallOrderById = mapper.findMallOrderById(id);
        MybatisUtil.closeSqlSession();
        return mallOrderById;
    }

    @Override
    public List<MallOrder> findMallOrderByUserId(Integer userid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        MallOrderMapper mapper = sqlSession.getMapper(MallOrderMapper.class);
        List<MallOrder> mallOrderByUserId = mapper.findMallOrderByUserId(userid);
        MybatisUtil.closeSqlSession();
        return mallOrderByUserId;
    }

    @Override
    public Integer insertMallOrder(MallOrder mallOrder) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        MallOrderMapper mapper = sqlSession.getMapper(MallOrderMapper.class);
        Integer integer = mapper.insertMallOrder(mallOrder);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
        return integer;
    }

    @Override
    public Integer updateMallOrder(MallOrder mallOrder) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        MallOrderMapper mapper = sqlSession.getMapper(MallOrderMapper.class);
        Integer integer = mapper.updateMallOrder(mallOrder);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
        return integer;
    }
}

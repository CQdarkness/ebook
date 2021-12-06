package com.dark.dao.impl;

import com.dark.dao.MallCartDao;
import com.dark.mappers.MallCartMapper;
import com.dark.model.MallCart;
import com.dark.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MallCartDaoImpl implements MallCartDao {
    @Override
    public  List<MallCart> findMallCartByUserId(Integer userid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        MallCartMapper mapper = sqlSession.getMapper(MallCartMapper.class);
        List<MallCart> mallCartById = mapper.findMallCartByUserId(userid);
        MybatisUtil.closeSqlSession();
        return mallCartById;
    }

    @Override
    public MallCart findMallCartByGoodsId(Integer goodsid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        MallCartMapper mapper = sqlSession.getMapper(MallCartMapper.class);
        MallCart mallCartById = mapper.findMallCartByGoodsId(goodsid);
        MybatisUtil.closeSqlSession();
        return mallCartById;
    }

    @Override
    public List<MallCart> findAllMallCart() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        MallCartMapper mapper = sqlSession.getMapper(MallCartMapper.class);
        List<MallCart> allMallCart = mapper.findAllMallCart();
        MybatisUtil.closeSqlSession();
        return allMallCart;
    }

    @Override
    public Integer insertMallCart(MallCart mallCart) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        MallCartMapper mapper = sqlSession.getMapper(MallCartMapper.class);
        Integer integer = mapper.insertMallCart(mallCart);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
        return integer;
    }

    @Override
    public Integer updateMallCart(MallCart mallCart) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        MallCartMapper mapper = sqlSession.getMapper(MallCartMapper.class);
        Integer integer = mapper.updateMallCart(mallCart);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
        return integer;
    }

    @Override
    public Integer deleteByGoodsId(Integer gid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        MallCartMapper mapper = sqlSession.getMapper(MallCartMapper.class);
        Integer integer = mapper.deleteByGoodsId(gid);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
        return integer;
    }
}

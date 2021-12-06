package com.dark.dao.impl;

import com.dark.dao.GoodsDao;
import com.dark.mappers.GoodsMapper;
import com.dark.model.Goods;
import com.dark.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao{
    @Override
    public Goods findGoodsById(Integer id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        Goods goodsById = mapper.findGoodsById(id);
        MybatisUtil.closeSqlSession();
        return goodsById;
    }

    @Override
    public List<Goods> findAllGoods() {
        List<Goods> goodsList=new ArrayList<>();
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        goodsList= mapper.findAllGoods();
        MybatisUtil.closeSqlSession();
        return goodsList;
    }

    @Override
    public List<Goods> findGoodsByCategoryId(Integer categoryId) {
        //此处先new ArrayList 可以在后续通过判断 list size来判断是否有内容，避免null判断
        List<Goods> goodsList=new ArrayList<>();
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        goodsList= mapper.findGoodsByCategoryId(categoryId);
        MybatisUtil.closeSqlSession();
        return goodsList;
    }

    @Override
    public Integer insertGoods(Goods goods) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        Integer integer = mapper.insertGoods(goods);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
        return integer;
    }

    @Override
    public Integer updateGoods(Goods goods) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        Integer integer = mapper.updateGoods(goods);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
        return integer;
    }

    @Override
    public List<Goods> searchGoodsByNameAndCategoryId(String name, Integer categoryid) {
        //此处先new ArrayList 可以在后续通过判断 list size来判断是否有内容，避免null判断
        List<Goods> goodsList=new ArrayList<>();
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        goodsList= mapper.searchGoodsByNameAndCategoryId(name,categoryid);
        MybatisUtil.closeSqlSession();
        return goodsList;
    }

    @Override
    public Integer deleteGoodsById(Integer id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        Integer integer = mapper.deleteGoodsById(id);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
        return integer;
    }
}

package com.dark.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dark.dao.CategoryDao;
import com.dark.dao.GoodsDao;
import com.dark.dao.impl.CategoryDaoImpl;
import com.dark.dao.impl.GoodsDaoImpl;
import com.dark.model.Category;
import com.dark.model.Goods;
import com.dark.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao=new GoodsDaoImpl();
    @Override
    public Goods findGoodsById(Integer id) {
        return goodsDao.findGoodsById(id);
    }

    @Override
    public PageInfo<Goods> findAllGoods(Integer pageNum,Integer pageSize ) {
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> allGoods = goodsDao.findAllGoods();
        PageInfo<Goods> pageInfo=new PageInfo<>(allGoods);
        return pageInfo ;
    }

    @Override
    public List<Goods> findGoodsByCategoryId(Integer categoryId) {
        //获取分类对象
        CategoryDao categoryDao=new CategoryDaoImpl();
        Category category = categoryDao.findCategoryById(categoryId);
        //将分类对象赋值给Goods中的Category对象
        List<Goods> goodsByCategoryIdList = goodsDao.findGoodsByCategoryId(categoryId);
        for(Goods goods:goodsByCategoryIdList){
            goods.setCategory(category);
        }
        return goodsByCategoryIdList;
    }

    @Override
    public Integer insertGoods(Goods goods) {
        return goodsDao.insertGoods(goods);
    }

    @Override
    public Integer updateGoods(Goods goods) {
        return goodsDao.updateGoods(goods);
    }

    @Override
    public PageInfo<Goods> searchGoodsByNameAndCategoryId(String name, Integer categoryid,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> goodsList = goodsDao.searchGoodsByNameAndCategoryId(name, categoryid);
        PageInfo<Goods> pageInfo=new PageInfo<>(goodsList);
        return pageInfo;
    }

    @Override
    public Integer deleteGoodsById(Integer id) {
        return goodsDao.deleteGoodsById(id);
    }
}

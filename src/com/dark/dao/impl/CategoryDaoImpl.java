package com.dark.dao.impl;

import com.dark.dao.CategoryDao;
import com.dark.mappers.CategoryMapper;
import com.dark.model.Category;
import com.dark.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao{
    @Override
    public Category findCategoryById(Integer id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        Category categoryById = mapper.findCategoryById(id);
        MybatisUtil.closeSqlSession();
        return categoryById;
    }

    @Override
    public List<Category> findAllCategory() {
        List<Category> categoriesList = new ArrayList<>();
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        categoriesList= mapper.findAllCategory();
        MybatisUtil.closeSqlSession();
        return categoriesList;
    }

    @Override
    public Integer insertCategory(Category category) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        Integer integer = mapper.insertCategory(category);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
        return integer;

    }

    @Override
    public Integer updateCategory(Category category) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        Integer integer = mapper.updateCategory(category);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
        return integer;
    }
}

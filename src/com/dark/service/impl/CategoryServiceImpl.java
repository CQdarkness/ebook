package com.dark.service.impl;

import com.dark.dao.CategoryDao;
import com.dark.dao.impl.CategoryDaoImpl;
import com.dark.model.Category;
import com.dark.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao=new CategoryDaoImpl();
    @Override
    public Category findCategoryById(Integer id) {
        return categoryDao.findCategoryById(id);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryDao.findAllCategory();
    }

    @Override
    public Integer insertCategory(Category category) {
        return categoryDao.insertCategory(category);
    }

    @Override
    public Integer updateCategory(Category category) {
        return categoryDao.updateCategory(category);
    }
}

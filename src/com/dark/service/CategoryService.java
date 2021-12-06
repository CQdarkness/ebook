package com.dark.service;

import com.dark.model.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 根据id查询category
     * @param id categoryid
     * @return category
     */
    public Category findCategoryById(Integer id);

    /**
     * 查询所有分类
     * @return 返回所有分类集合
     */
    public List<Category> findAllCategory();

    /**
     * 插入分类
     * @param category 分类对象
     * @return 返回受影响的行数
     */
    public Integer insertCategory(Category category);

    /**
     * 更新分类
     * * @param category 分类对象
     * @return 返回受影响的行数
     */
    public Integer updateCategory(Category category);
}

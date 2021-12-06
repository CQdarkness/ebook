package com.dark.service;

import com.github.pagehelper.PageInfo;
import com.dark.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsService {
    /**
     *通过id查询goods
     * @param id goods的ID
     * @return 指定id的Goods
     */
    public Goods findGoodsById(Integer id);

    /**
     *查询所有的goods
     * @param pageNum 需求的页码
     * @param pageSize 每页的数目
     * @return 分页对象
     */
    public PageInfo<Goods> findAllGoods(Integer pageNum,Integer pageSize);

    /**
     *通过分类id查询所有的goods
     * @param categoryId 分类ID
     * @return 返回同一分类的goods集合
     */
    public List<Goods> findGoodsByCategoryId(Integer categoryId);

    /**
     *插入goods
     * @param goods goods对象
     * @return 受影响的行数
     */
    public Integer insertGoods(Goods goods);

    /**
     * 更新goods
     * @param goods goods对象
     * @return 受影响的行数
     */
    public  Integer updateGoods(Goods goods);

    /**
     * 模糊查询
     * @param name 模糊的名字
     * @param categoryid 分类编号
     * @return 符合要求的Goods集合
     */
    public PageInfo<Goods> searchGoodsByNameAndCategoryId(String name, Integer categoryid,Integer pageNum,Integer pageSize);

    /**
     * 根据id删除商品
     * @param id 商品id
     * @return 受影响的行数
     */
    public Integer deleteGoodsById(Integer id);
}

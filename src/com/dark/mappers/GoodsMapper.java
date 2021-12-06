package com.dark.mappers;

import com.dark.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    /**
     *通过id查询goods
     * @param id goods的ID
     * @return 指定id的Goods
     */
    public Goods findGoodsById(Integer id);

    /**
     *查询所有的goods
     * @return goods集合
     */
    public List<Goods> findAllGoods();

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
    public List<Goods> searchGoodsByNameAndCategoryId(@Param("name") String name,@Param("categoryid") Integer categoryid);
    /**
     * 根据id删除商品
     * @param id 商品id
     * @return 受影响的行数
     */
    public Integer deleteGoodsById(Integer id);
}

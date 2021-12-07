package com.dark.dao;

import com.dark.model.MallOrder;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MallOrderDao {
    /**
     * 根据ID查订单
     * @param orderno
     * @return
     */
    MallOrder findMallOrderById(String orderno);

    /**
     * 根据用户ID查订单
     * @param userid
     * @param pageSize 每页数据
     * @param pageNum  第几页
     * @return
     */
    List<MallOrder> findMallOrderByUserIdPage(Integer userid, Integer pageNum, Integer pageSize);

    /**
     * 根据用户ID查订单
     * @param userid
     * @return
     */
    List<MallOrder> findMallOrderByUserId(Integer userid);

    /**
     * 插入新订单
     * @param mallOrder
     * @return
     */
    Integer insertMallOrder(MallOrder mallOrder);

    /**
     * 更新订单
     * @param mallOrder
     * @return
     */
    Integer updateMallOrder(MallOrder mallOrder);
}

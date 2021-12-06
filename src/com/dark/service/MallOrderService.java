package com.dark.service;

import com.dark.model.MallOrder;

import java.util.List;

public interface MallOrderService {
    /**
     * 根据ID查订单
     * @param orderno
     * @return
     */
    MallOrder findMallOrderById(String orderno);

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

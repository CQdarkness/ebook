package com.dark.service;

import com.dark.model.MallOrder;
import com.github.pagehelper.PageInfo;

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
     * @param pageNum 第几页
     * @param pageSize 每页几条数据
     * @return pageInfo对象
     */
    PageInfo<MallOrder> findMallOrderByUserIdPage(Integer userid,Integer pageNum,Integer pageSize);

    /**
     * 根据用户ID查订单
     * @param userid
     * @return pageInfo对象
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

    /**
     * 删除订单
     * @param orderno
     * @return
     */
    Integer deleteOrderByOrderNo(String orderno);

    /**
     * 分页查询所有订单
     * @return
     */
    PageInfo<MallOrder> findAllByPage(Integer pageNum,Integer pageSize);
}

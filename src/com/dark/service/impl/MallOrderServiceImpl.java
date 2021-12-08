package com.dark.service.impl;

import com.dark.dao.MallOrderDao;
import com.dark.dao.impl.MallOrderDaoImpl;
import com.dark.model.MallOrder;
import com.dark.service.MallOrderService;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class MallOrderServiceImpl implements MallOrderService {
    private MallOrderDao mallOrderDao=new MallOrderDaoImpl();
    @Override
    public MallOrder findMallOrderById(String orderno) {
        return mallOrderDao.findMallOrderById(orderno);
    }

    @Override
    public PageInfo<MallOrder> findMallOrderByUserIdPage(Integer userid,Integer pageNum,Integer pageSize) {
        List<MallOrder> mallOrderByUserId = mallOrderDao.findMallOrderByUserIdPage(userid, pageNum, pageSize);
        PageInfo<MallOrder> pageInfo=new PageInfo<>(mallOrderByUserId);
        return pageInfo;
    }

    @Override
    public List<MallOrder> findMallOrderByUserId(Integer userid) {

        return mallOrderDao.findMallOrderByUserId(userid);
    }

    @Override
    public Integer insertMallOrder(MallOrder mallOrder) {
        return mallOrderDao.insertMallOrder(mallOrder);
    }

    @Override
    public Integer updateMallOrder(MallOrder mallOrder) {
        return mallOrderDao.updateMallOrder(mallOrder);
    }

    @Override
    public Integer deleteOrderByOrderNo(String orderno) {
        return mallOrderDao.deleteOrderByOrderNo(orderno);
    }

    @Override
    public PageInfo<MallOrder> findAllByPage(Integer pageNum, Integer pageSize) {
        List<MallOrder> mallOrderByUserId = mallOrderDao.findAllByPage(pageNum, pageSize);
        PageInfo<MallOrder> pageInfo=new PageInfo<>(mallOrderByUserId);
        return pageInfo;
    }
}

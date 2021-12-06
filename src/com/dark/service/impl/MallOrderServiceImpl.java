package com.dark.service.impl;

import com.dark.dao.MallOrderDao;
import com.dark.dao.impl.MallOrderDaoImpl;
import com.dark.model.MallOrder;
import com.dark.service.MallOrderService;

import java.util.List;

public class MallOrderServiceImpl implements MallOrderService {
    private MallOrderDao mallOrderDao=new MallOrderDaoImpl();
    @Override
    public MallOrder findMallOrderById(Integer id) {
        return mallOrderDao.findMallOrderById(id);
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
}

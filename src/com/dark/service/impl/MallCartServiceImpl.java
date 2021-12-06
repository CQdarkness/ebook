package com.dark.service.impl;

import com.dark.dao.MallCartDao;
import com.dark.dao.impl.MallCartDaoImpl;
import com.dark.model.MallCart;
import com.dark.service.MallCartService;

import java.util.List;

public class MallCartServiceImpl implements MallCartService {

    private MallCartDao mallCartDao = new MallCartDaoImpl();

    @Override
    public  List<MallCart> findMallCartByUserId(Integer userid) {
        return mallCartDao.findMallCartByUserId(userid);
    }

    @Override
    public MallCart findMallCartByGoodsId(Integer goodsid) {
        return mallCartDao.findMallCartByGoodsId(goodsid);
    }

    @Override
    public List<MallCart> findAllMallCart() {
        return mallCartDao.findAllMallCart();
    }

    @Override
    public Integer insertMallCart(MallCart mallCart) {
        return mallCartDao.insertMallCart(mallCart);
    }

    @Override
    public Integer updateMallCart(MallCart mallCart) {
        return mallCartDao.updateMallCart(mallCart);
    }

    @Override
    public Integer deleteByGoodsId(Integer gid) {
        return mallCartDao.deleteByGoodsId(gid);
    }
}

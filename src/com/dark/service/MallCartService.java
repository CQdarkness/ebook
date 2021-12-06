package com.dark.service;

import com.dark.model.MallCart;

import java.util.List;

public interface MallCartService {
    /**
     * 根据Id查询购物车
     * @param userid
     * @return
     */
    List<MallCart> findMallCartByUserId(Integer userid);

    /**
     * 通过goodsid查询
     * @param goodsid
     * @return
     */
    MallCart findMallCartByGoodsId(Integer goodsid);

    /**
     * 获取所有的购物车
     * @return
     */
    List<MallCart> findAllMallCart();

    /**
     * 新增购物车
     * @param mallCart
     * @return
     */
    Integer insertMallCart(MallCart mallCart);

    /**
     * 编辑购物车
     * @param mallCart
     * @return
     */
    Integer updateMallCart(MallCart mallCart);

    /**
     * 删除购物车
     * @param gid
     * @return
     */
    Integer deleteByGoodsId(Integer gid);
}

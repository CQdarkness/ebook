package com.dark.service;

import com.dark.model.Address;

import java.util.List;

public interface AddressService {
    /**
     * 通过用户ID查询地址
     * @param userid
     * @return
     */
    List<Address> findAddressByUserId(Integer userid);

    /**
     * 添加新地址
     * @param address
     * @return
     */
    Integer insertAddress(Address address);

    /**
     * 更新地址
     * @param address
     * @return
     */
    Integer updateAddress(Address address);
}

package com.dark.mappers;

import com.dark.model.Address;
import com.dark.model.MallRegion;

import java.util.List;

public interface AddressMapper {
    /**
     * 通过用户ID查询地址
     * @param userid
     * @return
     */
    List<Address> findAddressByUserId(Integer userid);

    /**
     * 通过ID查询地址
     * @param id
     * @return
     */
    Address findAddressById(Integer id);

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

    /**
     * 获取所有父地址
     * @return
     */
    List<MallRegion> findAllProvince();

    /**
     * 根据父地址ID获取子集
     * @return
     */
    List<MallRegion> findAllRegionById(Integer id);
    /**
     * 删除地址
     * @param id
     * @return
     */
    Integer deleteAddress(Integer id);
}

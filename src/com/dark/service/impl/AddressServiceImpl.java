package com.dark.service.impl;

import com.dark.dao.AddressDao;
import com.dark.dao.impl.AddressDaoImpl;
import com.dark.model.Address;
import com.dark.model.MallRegion;
import com.dark.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDao addressDao=new AddressDaoImpl();
    @Override
    public List<Address> findAddressByUserId(Integer userid) {
        return addressDao.findAddressByUserId(userid);
    }

    @Override
    public Integer insertAddress(Address address) {
        return addressDao.insertAddress(address);
    }

    @Override
    public Integer updateAddress(Address address) {
        return addressDao.updateAddress(address);
    }

    @Override
    public List<MallRegion> findAllProvince() {
        return addressDao.findAllProvince();
    }

    @Override
    public List<MallRegion> findAllRegionById(Integer id) {
        return addressDao.findAllRegionById(id);
    }

    @Override
    public Integer deleteAddress(Integer id) {
        return addressDao.deleteAddress(id);
    }

    @Override
    public Address findAddressById(Integer id) {
        return addressDao.findAddressById(id);
    }
}

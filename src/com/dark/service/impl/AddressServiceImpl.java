package com.dark.service.impl;

import com.dark.dao.AddressDao;
import com.dark.dao.impl.AddressDaoImpl;
import com.dark.model.Address;
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
}

package com.dark.dao.impl;

import com.dark.dao.AddressDao;
import com.dark.mappers.AddressMapper;
import com.dark.model.Address;
import com.dark.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AddressDaoImpl implements AddressDao {
    @Override
    public List<Address> findAddressByUserId(Integer userid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
        List<Address> addressByUserId = mapper.findAddressByUserId(userid);
        MybatisUtil.closeSqlSession();
        return addressByUserId;
    }

    @Override
    public Integer insertAddress(Address address) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
        Integer integer = mapper.insertAddress(address);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
        return integer;
    }

    @Override
    public Integer updateAddress(Address address) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
        Integer integer = mapper.updateAddress(address);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
        return integer;
    }
}

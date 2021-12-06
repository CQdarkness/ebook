package com.dark.dao.impl;

import com.dark.dao.AddressDao;
import com.dark.mappers.AddressMapper;
import com.dark.model.Address;
import com.dark.model.MallRegion;
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
    public Address findAddressById(Integer id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
        Address addressById = mapper.findAddressById(id);
        MybatisUtil.closeSqlSession();
        return addressById;
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

    @Override
    public List<MallRegion> findAllProvince() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
        List<MallRegion> allProvince = mapper.findAllProvince();
        MybatisUtil.closeSqlSession();
        return allProvince;
    }

    @Override
    public List<MallRegion> findAllRegionById(Integer id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
        List<MallRegion> allRegionById = mapper.findAllRegionById(id);
        MybatisUtil.closeSqlSession();
        return allRegionById;
    }

    @Override
    public Integer deleteAddress(Integer id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
        Integer integer = mapper.deleteAddress(id);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
        return integer;
    }
}

package com.dark.dao;

import com.dark.model.MallUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MallUserDao {
    /**
     * 获取所有用户
     * @return 用户集合
     */
    List<MallUser> findAllUsers();

    /**
     * 通过ID找用户
     * @param id id
     * @return 用户对象
     */
    MallUser findMallUserById(Integer id);

    /**
     * 新增用户
     * @param mallUser 用户对象
     * @return 受影响的行数
     */
    int insertMallUser(MallUser mallUser);

    /**
     * 通过账户和密码查询用户
     * @param account 账号
     * @param password 密码
     * @return 用户对象
     */
    MallUser loginByAccountAndPassword(@Param("account") String account, @Param("password") String password);

    /**
     * 通过用户名查询用户
     * @param account 用户名
     * @return 用户对象
     */
    MallUser findUserByAccount(String account);

    /**
     * 邮箱验证
     * @param email
     * @return
     */
    MallUser findUserByEmail(String email);

    /**
     * 更新用户信息
     * @param mallUser
     */
    Integer updateUser(MallUser mallUser);
}

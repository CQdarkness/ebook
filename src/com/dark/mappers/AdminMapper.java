package com.dark.mappers;

import com.dark.model.Admin;

public interface AdminMapper {
    /**
     * 根据用户名查询Admin对象
     * @param account 用户名
     * @return 用户对象
     */
    public Admin findAdminByAccount(String account);
}

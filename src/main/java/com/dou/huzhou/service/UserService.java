package com.dou.huzhou.service;

import com.dou.huzhou.domain.UserInfo;

import java.util.Set;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/21, 12:15
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public interface UserService {
    /**
     * 新增
     * @param userInfo
     * @return
     */
    UserInfo save(UserInfo userInfo);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    UserInfo getByUsername(String username);

    /**
     * 根据用户名查找可用的角色
     * @param username
     * @return
     */
    Set<String> findRolesAvailable(String username);

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    UserInfo getById(Long id);

}

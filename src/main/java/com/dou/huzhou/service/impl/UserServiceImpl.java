package com.dou.huzhou.service.impl;

import com.dou.huzhou.dao.UserDao;
import com.dou.huzhou.domain.UserInfo;
import com.dou.huzhou.service.PasswordService;
import com.dou.huzhou.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/21, 12:18
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Service
public class UserServiceImpl implements UserService{

    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordService passwordService;

    @Override
    public UserInfo save(UserInfo userInfo) {
        try {
            passwordService.encryptPassword(userInfo);
            userDao.saveUser(userInfo);
        } catch (Exception e) {
            LOGGER.error("save failed, ",e);
        }
        return userInfo;
    }

    @Override
    public UserInfo getByUsername(String username) {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.getByUsername(username);
        } catch (Exception e) {
            LOGGER.error("findByUsername failed, ",e);
        }
        return userInfo;
    }

    @Override
    public Set<String> findRolesAvailable(String username) {
        Set<String> roles = null;
        try {
            roles = userDao.findRolesAvailable(username);
        } catch (Exception e) {
            LOGGER.error("findRolesAvailable failed", e);
        }
        return roles;
    }

    @Override
    public UserInfo getById(Long id) {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.getById(id);
        } catch (Exception e) {
            LOGGER.error("getById failed, ",e);
        }
        return userInfo;
    }

    @Override
    public List<UserInfo> getAll() {
        List<UserInfo> userInfos = null;
        try {
            userInfos = userDao.getAll();
        } catch (Exception e) {
            LOGGER.error("getAll failed, ",e);
        }
        return userInfos;
    }
}

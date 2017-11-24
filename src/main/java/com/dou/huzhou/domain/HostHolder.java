package com.dou.huzhou.domain;

import org.springframework.stereotype.Component;

/**
 * @Author: Francis Zhuge
 * @Description: 用户保持器（本线程中的）
 * @Date: Created in 2017/10/21, 17:24
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Component
public class HostHolder {
    private static ThreadLocal<UserInfo> users = new ThreadLocal<>();

    public UserInfo getUser(){
        return users.get();
    }
    public void setUsers(UserInfo userInfo){
        users.set(userInfo);
    }
    public void clear(){
        users.remove();
    }
}

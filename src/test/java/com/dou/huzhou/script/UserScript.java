package com.dou.huzhou.script;

import com.dou.huzhou.domain.UserInfo;
import com.dou.huzhou.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Francis Zhuge
 * @Description: 用户生成脚本
 * @Date: Created in 2017/11/25, 11:04
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserScript {

    @Autowired
    private UserService userService;

    @Test
    public void createUser(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserNo("01");
        userInfo.setUsername("admin");
        userInfo.setPassword("admin");
        userInfo.setAreaId(1l);
        userInfo.setLocked(false);
        userService.save(userInfo);

        userInfo = new UserInfo();
        userInfo.setUserNo("02");
        userInfo.setUsername("hzadmin");
        userInfo.setAreaId(1l);
        userInfo.setPassword("123");
        userInfo.setLocked(false);
        userService.save(userInfo);

        for(int i=0;i<39;i++){
            userInfo = new UserInfo();
            userInfo.setUserNo(""+i+3);
            userInfo.setUsername("hz"+i);
            userInfo.setCompanyId(Long.valueOf(1+i));
            userInfo.setAreaId(1l);
            userInfo.setPassword("123");
            userInfo.setLocked(false);
            userService.save(userInfo);
        }
    }
}

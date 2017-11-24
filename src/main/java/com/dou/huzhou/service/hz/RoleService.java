package com.dou.huzhou.service.hz;

import com.dou.huzhou.domain.UserInfo;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 16:25
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public interface RoleService {

    /**
     * 拼写出根据用户生成出的权限
     * @param user
     * @return
     */
    String spellAdminRole(UserInfo user);
}

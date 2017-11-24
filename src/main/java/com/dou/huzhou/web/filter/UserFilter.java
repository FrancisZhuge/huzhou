package com.dou.huzhou.web.filter;

import com.dou.huzhou.service.UserService;
import com.dou.huzhou.web.constant.Contants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/20, 15:38
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class UserFilter extends PathMatchingFilter{
    @Autowired
    private UserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(Contants.CURRENT_USER, userService.getByUsername(username));
        return true;
    }
}

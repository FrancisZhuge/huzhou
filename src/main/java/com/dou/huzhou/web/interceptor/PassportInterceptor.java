package com.dou.huzhou.web.interceptor;

import com.dou.huzhou.domain.HostHolder;
import com.dou.huzhou.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/21, 16:02
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class PassportInterceptor implements HandlerInterceptor{

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        hostHolder.setUsers(userService.getByUsername(username));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        hostHolder.clear();
    }
}

package com.dou.huzhou.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/15, 15:31
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * @LINFUXIN ：所有的无需数据的页面跳转，都在此处配置
     * 配置格式如下
     * addViewController：中为页面访问地址如localhost:8080/unauthorized，写/unauthorized即可，路径不能重复。
     * setViewName：中为页面存放路径，无需写template，也无需写.html
     * registry.addViewController("/unauthorized").setViewName("common/unauthorized");
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //TODO:在此书写你要配置的跳转页面

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}

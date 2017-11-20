package com.dou.huzhou.config;

import com.jagregory.shiro.freemarker.ShiroTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/20, 10:02
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Configuration
public class FreemakerConfig {
    @Autowired(required = false)
    private FreeMarkerConfigurer freeMarkerConfigurer;
    @Bean
    public freemarker.template.Configuration getFreemarkerConfiguration(){
        freemarker.template.Configuration configuration = freeMarkerConfigurer.getConfiguration();
        configuration.setSharedVariable("shiro",new ShiroTags());
        return configuration;
    }
}

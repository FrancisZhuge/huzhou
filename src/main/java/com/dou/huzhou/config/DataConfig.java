package com.dou.huzhou.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/9/29, 16:11
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Configuration
@PropertySource("classpath:properties/dev.properties")
public class DataConfig {

    private final static Logger LOGGER = LoggerFactory.getLogger(DataConfig.class);

    @Value("${connection.url}")
    private String connectionUrl;
    @Value("${connection.username}")
    private String connectionUsername;
    @Value("${connection.password}")
    private String connectionPassword;
    @Value("${druid.initialSize}")
    private int initialSize;
    @Value("${druid.minIdle}")
    private int minIdle;
    @Value("${druid.maxActive}")
    private int maxActive;
    @Value("${druid.maxWait}")
    private int maxWait;
    @Value("${druid.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${druid.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    @Value("${druid.validationQuery}")
    private String validationQuery;
    @Value("${druid.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${druid.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${druid.testOnReturn}")
    private boolean testOnReturn;
    @Value("${druid.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${druid.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;
    @Value("${druid.filters}")
    private String filters;

    /**
     * 配置Druid数据库连接池的dataSource
     * @return
     */
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(connectionUrl);
        dataSource.setUsername(connectionUsername);
        dataSource.setPassword(connectionPassword);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenConnectErrorMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            LOGGER.error("[DataConfig] create dataSource failed");
        }
        LOGGER.info("[DataConfig] create dataSource success");
        return dataSource;
    }

    /**
     * 配置sqlSessionFactory
     * @return
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactoryBean(){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        LOGGER.info("[DataConfig] create sqlSessionFactoryBean success");
        return sqlSessionFactoryBean;
    }
}

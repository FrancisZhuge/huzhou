package com.dou.huzhou.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/9/30, 16:11
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    private final static Logger LOGGER = LoggerFactory.getLogger(RedisConfig.class);

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.timeout}")
    private int timeout;
    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;
    @Value("${spring.redis.pool.max-wait}")
    private long maxWaitMillis;

    /**
     * Redis连接池配置
     * @return
     */
    @Bean
    public JedisPool redisPoolFactory() {
        LOGGER.info("Redis server address :"+host+":"+port);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
        LOGGER.info("Redis pool create success");
        return jedisPool;
    }

}

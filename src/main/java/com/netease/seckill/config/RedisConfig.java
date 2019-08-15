/**
 * @(#)JedisConfig.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.config;

import lombok.Data;
import redis.clients.jedis.Jedis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * @author 彭羽(wb.pengyu @ mesg.corp.netease.com)
 */
@Data
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.jedis.pool.max-active}")
    private int poolMaxTotal;

    @Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private long poolMaxWait;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int poolMaxIdle;

    @Value("${spring.redis.timeout}")
    private int timeout;

}

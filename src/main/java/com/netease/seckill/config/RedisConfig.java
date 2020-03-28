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
 * @author 彭羽(pengyu @ .corp.netease.com)
 */
@Data
@Configuration
public class RedisConfig {

    @Value("${netease.redis.host}")
    private String host;

    @Value("${netease.redis.port}")
    private int port;

//    @Value("${netease.redis.password}")
    private String password;

    @Value("${netease.redis.poolMaxTotal}")
    private int poolMaxTotal;

    @Value("${netease.redis.minIdle}")
    private int minIdle;

    @Value("${netease.redis.poolMaxWait}")
    private long poolMaxWait;

    @Value("${netease.redis.poolMaxIdle}")
    private int poolMaxIdle;

    @Value("${netease.redis.timeout}")
    private int timeout;

}

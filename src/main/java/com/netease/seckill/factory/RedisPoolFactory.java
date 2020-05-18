/**
 * @(#)RedisPoolFactory.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

//import com.netease.seckill.config.RedisConfig;

/**
 * @author 彭羽(pengyu @.corp.netease.com)
 */
//@Service
//public class RedisPoolFactory {
//
//    @Autowired
//    RedisConfig redisConfig;
//
//    @Bean
//    public JedisPool JedisPoolFactory() {
//        JedisPoolConfig poolConfig = new JedisPoolConfig();
//        poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
//        poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
//        poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);
//        JedisPool jp = new JedisPool(poolConfig, redisConfig.getHost(),
//            redisConfig.getPort(), redisConfig.getTimeout() * 1000,
//            redisConfig.getPassword(), 0);
//        return jp;
//    }
//}

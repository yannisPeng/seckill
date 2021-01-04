/**
 * @(#)RedissonServiceImpl.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.net.seckill.service.impl;

import org.redisson.api.RLock;
import org.springframework.stereotype.Service;

import com.net.seckill.service.RedissonService;

@Service
public class RedissonServiceImpl implements RedissonService {

//    @Autowired
//    private RedissonClient redissonClient;

    /**
     * 获取锁
     *
     * @param objectName
     * @return
     */
    @Override
    public RLock getRLock(String objectName) {
//        RLock rLock = redissonClient.getLock(objectName);
//        return rLock;
        return null;
    }

}

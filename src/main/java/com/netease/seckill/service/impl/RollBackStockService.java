/**
 * @(#)RollBackStockService.java, 2019/8/16.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.service.impl;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.netease.seckill.cache.RedisService;
import com.netease.seckill.service.RedissonService;

/**
 * @author 彭羽(wb.pengyu @ mesg.corp.netease.com)
 */
@Service
public class RollBackStockService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedissonService redissonService;

    @KafkaListener(topics = { "order-cancel" })
    public void getMessage(String msg) {
        try {
            //回滚库存
            Long skuId = Long.valueOf(msg);
            RLock rLock = redissonService.getRLock(skuId + "-" + "lock");

            boolean bs = rLock.tryLock(30, 6, TimeUnit.SECONDS);

            if (bs) {
                //从redis获取当前商品内存
                Integer instock = redisService.get(skuId + "-" + "inStock",
                    Integer.class);
                if (instock != null && instock > 0) {
                    boolean flag = redisService.set(skuId + "-" + "inStock",
                        instock + 1);
                    //释放锁
                    rLock.unlock();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

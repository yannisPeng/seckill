/**
 * @(#)StockServiceImpl.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.service.impl;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.seckill.cache.RedisService;
import com.netease.seckill.service.RedissonService;
import com.netease.seckill.service.StockService;

/**
 * @author 彭羽(pengyu @corp.netease.com)
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedissonService redissonService;

    @Override
    public boolean deductionStock(long skuId) throws InterruptedException {

        RLock rLock = redissonService.getRLock(skuId + "-" + "lock");

        boolean bs = rLock.tryLock(1000, 6, TimeUnit.SECONDS);

        if (bs) {
            //从redis获取当前商品内存
            Integer instock = redisService.get(skuId + "-" + "inStock",
                Integer.class);
            if (instock != null && instock > 0) {
                boolean flag = redisService.set(skuId + "-" + "inStock",
                    instock - 1);
                //释放锁
                rLock.unlock();
                return true;
            }
        }
        return false;
    }

    @Override
    public int getTotalStock(long skuId) throws InterruptedException {
        RLock rLock = redissonService.getRLock(skuId + "-" + "lock");

        boolean bs = rLock.tryLock(1000, 6, TimeUnit.SECONDS);

        Integer instock = 0;

        if (bs) {
            instock = redisService.get(skuId + "-" + "inStock", Integer.class);
            if (instock <= 0) {
                rLock.unlock();
                return 0;
            }
        }
        return 1;
    }

}

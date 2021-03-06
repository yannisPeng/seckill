/**
 * @(#)StockServiceImpl.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.net.seckill.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

//import com.netease.seckill.cache.RedisService;
import com.net.seckill.service.RedissonService;
import com.net.seckill.service.StockService;

@Service
public class StockServiceImpl implements StockService {

    private ThreadLocal<Thread> rlock = new ThreadLocal<>();

    private static final ThreadLocal threadLocal = new ThreadLocal();

//    @Autowired
//    private RedisService redisService;
    @Autowired
    private Test2 test2;
    @Autowired
    private RedissonService redissonService;
    @Resource
    private DefaultRedisScript<String> redisScript;
    @Autowired
    private RedisTemplate stringRedisTemplate;

    @Override
    public boolean deductionStock(long skuId,long userId) throws InterruptedException {

        rlock.set(Thread.currentThread());

        RLock rLock = redissonService.getRLock(skuId + "-" + "lock");

        rLock.tryLock();

        List<String> keys = Arrays.asList(skuId + "-" + "inStock");
        Object execute = stringRedisTemplate.execute(redisScript, keys, "");
        if(execute.equals(0)){
            return false;
        }else{
            if(rLock.isLocked() && rLock.isHeldByCurrentThread()){
                rLock.unlock();
            }
            Thread.sleep(10);
            return true;
        }

        //从redis获取当前商品库存
//        Integer instock = redisService.get(skuId + "-" + "inStock",
//            Integer.class);
//        if (instock != null && instock > 0) {
//            redisService.decr(skuId + "-" + "inStock");
//            //处理用户信息包括下单
//            Thread.sleep(10);
//            //释放锁
//            if(rLock.isLocked() && rLock.isHeldByCurrentThread()){
//                rLock.unlock();
//            }
//        }
//        return false;
    }

    @Override
    public int getTotalStock(long skuId) throws InterruptedException {
        RLock rLock = redissonService.getRLock(skuId + "-" + "lock");

        boolean bs = rLock.tryLock(1000, 30, TimeUnit.SECONDS);

        Integer instock = 0;

        if (bs) {
//            instock = redisService.get(skuId + "-" + "inStock", Integer.class);
            if (instock == null || instock <= 0) {
                rLock.unlock();
                return 0;
            }else{
                rLock.unlock();
                return instock;
            }
        }
        return instock;
    }

    @Override
    public String getTotalStock() {
        return test2.getCache(System.currentTimeMillis());
    }

    @Override
    public void dealInfo(String info) throws Exception {
        String message = info;
        throw new Exception();
    }

}

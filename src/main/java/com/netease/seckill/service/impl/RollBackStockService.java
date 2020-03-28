///**
// * @(#)RollBackStockService.java, 2019/8/16.
// * <p/>
// * Copyright 2019 Netease, Inc. All rights reserved.
// * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
// */
//package com.netease.seckill.service.impl;
//
//import java.util.concurrent.TimeUnit;
//
//import org.redisson.api.RLock;
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import com.netease.seckill.cache.RedisService;
//import com.netease.seckill.dao.IdempotentMapper;
//import com.netease.seckill.po.Idempotent;
//import com.netease.seckill.service.RedissonService;
//
///**
// * @author 彭羽(pengyu @ .corp.netease.com)
// */
//@Service
//public class RollBackStockService {
//
//    @Autowired
//    private RedisService redisService;
//
//    @Autowired
//    private RedissonService redissonService;
//
//    @Autowired
//    private IdempotentMapper idempotentMapper;
//
//    @KafkaListener(topics = {"order-cancel"})
//    public void getMessage(String msg) {
//        try {
//            //回滚库存
//            String[] strs = msg.split("-");
//            //消费之前做幂等，防止多机消费
//            Idempotent idempotent = idempotentMapper.selectByRecord(msg);
//            if (idempotent == null) {
//                idempotent = new Idempotent();
//                idempotent.setRecord(msg);
//                idempotent.setTag("consum");
//                idempotent.setOptTime(System.currentTimeMillis());
//                idempotentMapper.insert(idempotent);
//            } else {
//                return;
//            }
//            Long skuId = Long.valueOf(strs[0]);
//            RLock rLock = redissonService.getRLock(skuId + "-" + "lock");
//
//            boolean bs = rLock.tryLock(1000, 6, TimeUnit.SECONDS);
//
//            if (bs) {
//                //从redis获取当前商品内存
//                Integer instock = redisService.get(skuId + "-" + "inStock",
//                        Integer.class);
//                if (instock != null && instock > 0) {
//                    boolean flag = redisService.set(skuId + "-" + "inStock",
//                            instock + 1);
//                    //释放锁
//                    rLock.unlock();
//                }
//            }
//        } catch (Exception e) {
//            //这里需要告警
//            e.printStackTrace();
//        }
//    }
//
//}

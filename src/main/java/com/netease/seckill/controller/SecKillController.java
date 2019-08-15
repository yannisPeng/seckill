/**
 * @(#)SecKillController.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netease.seckill.cache.RedisService;
import com.netease.seckill.service.StockService;

/**
 * @author 彭羽(pengyu@corp.netease.com)
 */
@RequestMapping("/xhr/seckill")
@RestController
public class SecKillController {

    @Autowired
    private StockService stockService;

    @RequestMapping("/buyGoods")
    public String buyGoods(
        @RequestParam(required = true, value = "userId") long userId,
        @RequestParam(required = true, value = "skuId") long skuId)
        throws UnknownHostException, InterruptedException {

        //TODO 风控用户校验
        if (userId == -1) {
            return "this user is risk controller user";
        }

        //判断当前skuid库存是否为0 关闭接口，提示结束
        int total = stockService.getTotalStock(skuId);
        if (total <= 0) {
            return "current sku is sold out";
        }

        //扣减库存
        boolean dflag = stockService.deductionStock(skuId);

        if (dflag == true) {
            //增加总库存
            //TODO 扣减成功，塞入队列，订阅并下单

        }

        return "success";
    }

}

/**
 * @(#)SecKillController.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 彭羽(pengyu@corp.netease.com)
 */
@RequestMapping("/xhr/seckill")
@RestController
public class SecKillController {

    @RequestMapping("/buyGoods")
    public String buyGoods(@RequestParam(required = true,value = "userId") long userId,
                           @RequestParam(required = true,value = "skuId") long skuId,
                           @RequestParam(required = true,value = "itemId") long itemId){

        //TODO 无效用户校验

        //TODO 风控用户校验

        //TODO 接口定时开放

        return "success";
    }

}
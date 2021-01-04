/**
 * @(#)SecKillController.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.net.seckill.controller;

import com.net.seckill.service.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/xhr/rabbitmq")
@RestController
public class RabbitMqController {

    @Autowired
    private RabbitMqService rabbitMqService;


    /**
     * 测试线程池
     */
    @RequestMapping("/testThreadPool")
    public String buyGoods() {
        rabbitMqService.sendMsg();
        return "success";
    }

}

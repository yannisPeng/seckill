/**
 * @(#)SecKillController.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.controller;

import com.netease.loadBalancing.RoundRobinStrategy;
import com.netease.loadBalancing.StrategyExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/xhr/test")
@RestController
public class TestController {

    ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    @RequestMapping("/testBuilder2")
    public String testBuilder2() {
        StrategyExecutor.build("新名字").execute(new RoundRobinStrategy());
        return "success";
    }

}

/**
 * @(#)SecKillController.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.controller;

import com.netease.seckill.delay.core.TaskScheduler;
import com.netease.seckill.delay.persistence.TaskParam;
import com.netease.seckill.delayTask.CallFailDelayTask;
import com.netease.seckill.service.impl.StockServiceImpl;
import com.netease.seckill.test.People;
import com.netease.seckill.util.ContextUtil;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;

@RequestMapping("/xhr/test")
@RestController
public class TestController {

    @Autowired
    private TaskScheduler taskScheduler;
    @Autowired
    private StockServiceImpl stockService;

    @RequestMapping(value = "/testBuilder2", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    public String testBuilder2() {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            SecureRandom random = new SecureRandom();
            int i = random.nextInt(10000);
            taskScheduler.doDelaySchedule(CallFailDelayTask.class, TaskParam.builder().addParam("roundNum", i)
                    .setTaskTag("延时任务").build(), 1000);
            return "fail";
        }
    }

    @RequestMapping(value = "/testBuilder", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    public String testBuilder() {
        ObjectSizeCalculator.getObjectSize(new Object());
        return "";
    }

    public static void main(String[] args) {
        System.out.println(ObjectSizeCalculator.getObjectSize(new Object()));
    }

}

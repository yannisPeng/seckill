/**
 * @(#)IdempotentController.java, 2019/8/22.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.net.seckill.controller;

import com.net.seckill.po.Idempotent;
import com.net.seckill.service.IdempotentService;
import com.net.seckill.service.impl.RedissonServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/xhr/idempotent")
@RestController
public class IdempotentController {

    @Autowired
    private IdempotentService idempotentService;

    @Autowired
    private BeanFactory beanFactory;

    /**
     * 获取幂等值
     */
    @RequestMapping("/selectByRecord")
    public Idempotent selectByRecord(
            @RequestParam(value = "record", required = true) String record) {
        return beanFactory.getBean(IdempotentService.class).selectByRecord(record);
    }

    /**
     * 获取幂等值
     */
    @RequestMapping("/updateOptTime")
    public String updateOptTime(
            @RequestParam(value = "id", required = true) long id) {
        idempotentService.updateOptTime(id);
        return "success";
    }

    /**
     * 获取幂等值
     */
    @RequestMapping("/testBeanFactory")
    public String testBeanFactory() {
        BeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.getBean("redissonServiceImpl",RedissonServiceImpl.class).getRLock("abc");
        return "success";
    }


}

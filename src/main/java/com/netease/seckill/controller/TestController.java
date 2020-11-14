/**
 * @(#)SecKillController.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.controller;

import com.alibaba.fastjson.JSON;
import com.netease.seckill.po.Student;
import com.netease.seckill.up.Action;
import com.netease.seckill.up.LifeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/xhr/test")
@RestController
public class TestController {

    @Autowired
    private Action action;

    ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    @RequestMapping("/testBuilder")
    public String testBuilder() {
        Student student = new Student("1");
        threadLocal.set(student);
        student.setName("2");
        LifeInterface.build("张三").buyDish(action);
        Student o = (Student)threadLocal.get();
        return o.getName();
    }

    @RequestMapping("/testBuilder1")
    public String testBuilder1() {
        threadLocal.set(3);
        return String.valueOf(threadLocal.get());
    }


    @RequestMapping("/testBuilder2")
    public String testBuilder2() {

        return "";
    }

}

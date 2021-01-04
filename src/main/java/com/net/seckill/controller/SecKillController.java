/**
 * @(#)SecKillController.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.net.seckill.controller;

import com.alibaba.fastjson.JSON;
import com.net.seckill.po.StudentService;
import com.net.seckill.service.StockService;
import com.net.seckill.spring.event.TeacherPublisher;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.concurrent.ConcurrentHashMap;

@RequestMapping("/xhr/seckill")
@RestController
public class SecKillController implements ApplicationContextAware, BeanFactoryAware {

    private static final ConcurrentHashMap<String,String> testTomcatMap = new ConcurrentHashMap<>();

    @Autowired
    private StockService stockService;

    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    @Autowired
    private TeacherPublisher teacherPublisher;


    /**
     * 库存扣减
     */
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
//        int total = stockService.getTotalStock(skuId);
//        if (total <= 0) {
//            return "current sku is sold out";
//        }

        //扣减库存
        boolean dflag = stockService.deductionStock(skuId, userId);

        if (dflag == true) {
            //增加总库存
            //TODO 扣减成功，塞入队列，订阅并下单
            return "success";
        } else {
            return "fail";
        }

    }

    /**
     * 测试factory bean
     */
    @RequestMapping("/sayhi")
    public String buyGoods() throws Exception {
        StudentService studentFactoryBean = (StudentService) beanFactory.getBean("studentFactoryBean");
        return JSON.toJSONString(studentFactoryBean.sayHi());
    }

    /**
     * 布置作业
     */
    @RequestMapping("/publishHomework")
    public String publishHomework(@RequestBody String content) {
        teacherPublisher.publishHomeWork(content);
        return "success";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    /**
     * 测试tomcat线程池
     */
    @RequestMapping("/map")
    public String map() {
        System.out.println(testTomcatMap);
        return "success";
    }


    /**
     * 测试tomcat线程池
     */
    @RequestMapping("/testTomcatThread")
    public String testTomcatThread() {
        if(testTomcatMap.get(Thread.currentThread().getName() + Thread.currentThread().getId()) != null){
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId());
        }
        testTomcatMap.put(Thread.currentThread().getName() + Thread.currentThread().getId(), "1");
        return "success";
    }

}

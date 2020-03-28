/**
 * @(#)ProxyTest.java, 2020/2/23.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.test;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.netease.seckill.proxy.ControllerProxy;
import com.netease.seckill.service.StockService;
import com.netease.seckill.service.impl.StockServiceImpl;

/**
 * @Title: ProxyTest
 * @Package com.netease.seckill.test
 * @Description:
 * @Author pengy
 * @Date 2020/2/23 19:57
 * @Version v1.0
 */
public class ProxyTest {

    public static void main(String[] args) throws InterruptedException {

//        StockService stockService = new StockServiceImpl();
//        ControllerProxy proxy = new ControllerProxy(stockService);
//        StockService serviceProxy = (StockService) proxy.createProxy();
//        serviceProxy.getTotalStock();

        List<String> list = new ArrayList<>();
        list.add("1");
        for(String str : list){
            str = "abc";
            list.remove(str);
        }
    }

}

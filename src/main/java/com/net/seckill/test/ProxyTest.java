/**
 * @(#)ProxyTest.java, 2020/2/23.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.net.seckill.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: ProxyTest
 * @Package com.netease.seckill.test
 * @Description:
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

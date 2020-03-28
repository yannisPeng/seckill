/**
 * @(#)CglibProxy.java, 2020/2/23.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @Title: CglibProxy
 * @Package com.netease.seckill.proxy
 * @Description:
 * @Author pengy
 * @Date 2020/2/23 20:30
 * @Version v1.0
 */
public class CglibProxy implements MethodInterceptor {

    public Object CreatProxyedObj(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(clazz);

        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects,
        MethodProxy methodProxy) throws Throwable {
        // 这里增强
        System.out.println("收钱");

        return methodProxy.invokeSuper(o, objects);
    }
}

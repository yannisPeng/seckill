/**
 * @(#)ControllerProxy.java, 2020/2/23.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.net.seckill.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Title: ControllerProxy
 * @Description:
 * @Date 2020/2/23 19:54
 * @Version v1.0
 */
public class ControllerProxy implements InvocationHandler {

    private Object object;

    public ControllerProxy() {}

    public ControllerProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable {
        System.out.println("进入代理类");
        Object result = method.invoke(proxy, args);
        return result;
    }

    public Object createProxy() {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
            object.getClass().getInterfaces(), this);
    }

}

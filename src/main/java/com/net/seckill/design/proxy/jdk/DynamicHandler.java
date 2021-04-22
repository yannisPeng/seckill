package com.net.seckill.design.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/1/25
 */
public class DynamicHandler implements InvocationHandler {

    Object target;

    public DynamicHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(target, args);
        after();
        return invoke;
    }

    void before(){
        System.out.println("before");
    }

    void after(){
        System.out.println("after");
    }

}

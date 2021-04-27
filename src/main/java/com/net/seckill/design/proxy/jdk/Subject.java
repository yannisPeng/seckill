package com.net.seckill.design.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/1/25
 */
public class Subject {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        DynamicHandler handler = new DynamicHandler(userService);

        UserService proxyService = (UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), handler);

        proxyService.update();
    }

}

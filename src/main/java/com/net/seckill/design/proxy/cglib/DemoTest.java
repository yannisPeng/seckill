package com.net.seckill.design.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/1/25
 */
public class DemoTest {

    public static void main(String[] args) {

        Interceptor interceptor = new Interceptor();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallback(interceptor);

        Dao o = (Dao) enhancer.create();
        o.update();

    }

}

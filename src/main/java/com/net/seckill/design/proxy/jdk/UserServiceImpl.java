package com.net.seckill.design.proxy.jdk;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/1/25
 */
public class UserServiceImpl implements UserService {

    @Override
    public Object select() {
        System.out.println("select");
        return new Object();
    }

    @Override
    public void update() {
        System.out.println("update");
    }

}

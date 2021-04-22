package com.net.seckill.design.observer;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/1/26
 */
public abstract class Observer {

    protected Subject subject;

    abstract void update(int state);

}

package com.net.seckill.design.observer;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/1/26
 */
public class BObserver extends Observer {

    public BObserver(Subject subject) {
        this.subject = subject;
        this.subject.register(this);
    }

    @Override
    public void update(int state) {
        System.out.println("b update " + state);
    }
}

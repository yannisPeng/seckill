package com.net.seckill.design.observer;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/1/26
 */
public class CObserver extends Observer {

    public CObserver(Subject subject) {
        this.subject = subject;
        this.subject.register(this);
    }

    @Override
    public void update(int state) {
        System.out.println("c update " + state);
    }
}

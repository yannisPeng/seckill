package com.net.seckill.design.observer;

import java.util.Observable;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/1/26
 */
public class AObserver extends Observer {

    public AObserver(Subject subject) {
        this.subject = subject;
        this.subject.register(this);
    }

    @Override
    void update(int state) {
        System.out.println("a update " + state);
    }
}

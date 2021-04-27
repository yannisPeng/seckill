package com.net.seckill.design.observer;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/1/26
 */
public class ObserverDemo {

    public static void main(String[] args) {

        Subject subject = new Subject();
        AObserver aobserver = new AObserver(subject);
        BObserver bobserver = new BObserver(subject);
        CObserver cobserver = new CObserver(subject);

        subject.changeState(100);

    }

}

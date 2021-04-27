package com.net.seckill.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShangTest {

    private static Object objectLock = new Object();

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            lock.lock();
            condition.signal();
            System.out.println("无意义操作");
            lock.unlock();

        }, "t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                condition.await();
                System.out.println("被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();

        new Thread(() -> {
            lock.lock();
            condition.signal();
            System.out.println("通知");
            lock.unlock();
        }, "t3").start();

    }

}

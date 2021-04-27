package com.net.seckill.lock;

public class LockB{

    public static synchronized void lockB(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockA.lockA();
    }

}

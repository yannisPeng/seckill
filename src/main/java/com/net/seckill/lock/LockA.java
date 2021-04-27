package com.net.seckill.lock;

public class LockA implements Lock{

    public static synchronized void lockA(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockB.lockB();
    }

}

package com.net.seckill.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestLock {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);

        service.submit(new Thread(new Runnable(){
            @Override
            public void run() {
                LockA.lockA();
            }
        }));

        service.submit(new Thread(new Runnable(){
            @Override
            public void run() {
                LockB.lockB();
            }
        }));

        service.shutdown();

    }

}

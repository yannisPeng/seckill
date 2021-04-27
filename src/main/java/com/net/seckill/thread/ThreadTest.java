package com.net.seckill.thread;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTest {

    private static final ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) throws InterruptedException {


        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), new DefaultThreadFactory("thread-local-factory"));

        while (Runtime.getRuntime().freeMemory() > 0) {
            Thread.sleep(1000);
            System.out.print("总内存：" + Runtime.getRuntime().totalMemory() / 1024 / 1024);
            System.out.print("| 剩余内存：" + Runtime.getRuntime().freeMemory() / 1024 / 1024);
            System.out.print("| 使用内存：" + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024);
            poolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.print("| " + Thread.currentThread().getName());
                    threadLocal.set(new byte[10 * 1024 * 1024]);
                    System.out.println("| " + threadLocal.get().hashCode() / 10);
                    System.gc();
                }
            }, "");
        }
    }
}

package com.netease.seckill.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/10/21
 */
public class RandomTest {

    public static void main(String[] args) throws InterruptedException {

        // 声明多线程
        ExecutorService service = Executors.newCachedThreadPool();
        // 共享 ThreadLocalRandom
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int i = 0; i < 100; i++) {
            // 多线程执行随机数并打印结果
            service.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ":" + threadLocalRandom.nextInt(10));
            });
        }

//        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
//        for (int i = 0; i < 10; i++) {
//            System.out.println(threadLocalRandom.nextInt(10));
//        }
    }
}

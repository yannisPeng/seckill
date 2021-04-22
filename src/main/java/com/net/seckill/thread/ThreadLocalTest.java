package com.net.seckill.thread;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/4/20
 */
public class ThreadLocalTest {

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            Thread.sleep(10);
            System.out.println("剩余内存：" + Runtime.getRuntime().freeMemory());

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    ThreadLocal threadLocal = new ThreadLocal();
                    threadLocal.set(new byte[5 * 1024 * 1024]);
                    threadLocal = null;
                }
            });
            thread.start();
            System.gc();
        }
    }
}

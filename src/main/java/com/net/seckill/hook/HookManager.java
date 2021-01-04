package com.net.seckill.hook;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/12/11
 */
public class HookManager {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("call hook");
            }
        }));

        while (true){

        }

    }
}

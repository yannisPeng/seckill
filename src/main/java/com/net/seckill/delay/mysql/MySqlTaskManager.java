package com.net.seckill.delay.mysql;

import io.netty.util.HashedWheelTimer;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/1/29
 */
public class MySqlTaskManager implements TaskManager {

    // 是否启动
    private volatile boolean STARTED = false;

    private static HashedWheelTimer TIMER;

    @Override
    public void start() {
        if(STARTED){
            synchronized (this){

                if(STARTED){
                    return;
                }

                TIMER = new HashedWheelTimer(10, TimeUnit.SECONDS);
                TIMER.start();



            }
        }
    }

}

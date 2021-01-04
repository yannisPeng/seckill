package com.net.seckill.design.module;

/**
 * Description: 抽象模板类
 *
 * @author 10014994
 * @since 2020/6/16
 */
public abstract class AbstractModule {

    abstract void goHome();

    abstract void gotoSleep();

    public final void doMoudle(){
        goHome();
        gotoSleep();
    }

}

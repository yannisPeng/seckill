package com.net.seckill.design.module;

import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/6/16
 */
@Service
public class MomService extends AbstractModule {

    @Override
    void goHome() {
        System.out.println("go home");
    }

    @Override
    void gotoSleep() {
        System.out.println("go to sleep");
    }

}

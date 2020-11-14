package com.netease.loadBalancing;

/**
 * Description: 随机策略
 *
 * @author 10014994
 * @since 2020/11/14
 */
public class RoundStrategy extends AbstractStrategy{

    @Override
    public void doStrategy() {
        System.out.println("RoundStrategy");
    }

}

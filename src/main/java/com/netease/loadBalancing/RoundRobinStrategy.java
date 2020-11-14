package com.netease.loadBalancing;

/**
 * Description: 轮询策略
 *
 * @author 10014994
 * @since 2020/11/14
 */
public class RoundRobinStrategy extends AbstractStrategy {

    @Override
    public void doStrategy() {
        System.out.println("RoundRobinStrategy");
    }

}

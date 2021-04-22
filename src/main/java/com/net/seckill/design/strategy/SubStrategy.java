package com.net.seckill.design.strategy;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/1/20
 */
public class SubStrategy implements Strategy {
    @Override
    public int doOperate(int a, int b) {
        return a - b;
    }
}

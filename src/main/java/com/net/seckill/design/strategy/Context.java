package com.net.seckill.design.strategy;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/1/20
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int execute(int a, int b){
        return strategy.doOperate(a, b);
    }
}

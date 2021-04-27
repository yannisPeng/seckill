package com.net.seckill.design.strategy;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/1/20
 */
public class StrategyContext {

    public static void main(String[] args) {

        Context add = new Context(new AddStrategy());
        Context sub = new Context(new SubStrategy());

        int a = 1;
        int b = 1;
        System.out.println(add.execute(a, b));
        System.out.println(sub.execute(a, b));
    }

}

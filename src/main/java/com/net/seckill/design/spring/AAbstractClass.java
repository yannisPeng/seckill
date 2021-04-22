package com.net.seckill.design.spring;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/2/4
 */
public abstract class AAbstractClass implements AInterface {

    private String name;

    void doSomething(){

    }

    public void init(){
        this.doSomething();
        this.name = "张三";
    }

}

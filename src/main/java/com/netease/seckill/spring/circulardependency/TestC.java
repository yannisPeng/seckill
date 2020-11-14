package com.netease.seckill.spring.circulardependency;

import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/7/28
 */
public class TestC {

    private TestA testA;

    public TestC(TestA testA) {
        this.testA = testA;
    }

    public void c(){
        testA.a();
    }

    public TestA getTestA() {
        return testA;
    }

    public void setTestA(TestA testA) {
        this.testA = testA;
    }
}

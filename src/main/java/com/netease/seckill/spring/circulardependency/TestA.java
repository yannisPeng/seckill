package com.netease.seckill.spring.circulardependency;

import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/7/28
 */
public class TestA {

    private TestB testB;

    public TestA(TestB testB) {
        this.testB = testB;
    }

    public void a() {
        testB.b();
    }

    public TestB getTestB() {
        return testB;
    }

    public void setTestB(TestB testB) {
        this.testB = testB;
    }
}

package com.net.seckill.spring.circulardependency;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/7/28
 */
public class TestB {

    private TestC testC;

    public TestB(TestC testC) {
        this.testC = testC;
    }

    public void b(){
        testC.c();
    }

    public TestC getTestC() {
        return testC;
    }

    public void setTestC(TestC testC) {
        this.testC = testC;
    }
}

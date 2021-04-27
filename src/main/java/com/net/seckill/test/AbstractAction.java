/**
 * @(#)AbstractAction.java, 2020/2/19.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.net.seckill.test;

/**
 * @Title: AbstractAction
 * @Description:
 * @Date 2020/2/19 16:59
 * @Version v1.0
 */
public abstract class AbstractAction implements Action{

    public void doSomething(){
        try{
            this.main();
        }catch (Exception e){
            fail();
        }
    }

    abstract void main();

    public void fail() {

    }

}
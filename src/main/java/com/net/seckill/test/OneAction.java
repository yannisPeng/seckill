/**
 * @(#)OneAction.java, 2020/2/19.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.net.seckill.test;

/**
 * @Title: OneAction
 * @Package com.netease.seckill.test
 * @Description:
 * @Date 2020/2/19 16:56
 * @Version v1.0
 */
public interface OneAction extends SomeAction,TwoAction{

    default void testStatic(){

    }

}
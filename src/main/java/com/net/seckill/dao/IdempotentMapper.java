/**
 * @(#)IdempotentMapper.java, 2019/8/19.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.net.seckill.dao;


import com.net.seckill.po.Idempotent;

public interface IdempotentMapper {

    int insert(Idempotent idempotent);

    Idempotent selectByRecord(String record);

    int updateOptTime(long optTime, long id);

}
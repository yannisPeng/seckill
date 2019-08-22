/**
 * @(#)IdempotentMapper.java, 2019/8/19.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import com.netease.seckill.po.Idempotent;

/**
 * @author 彭羽(pengyu@corp.netease.com)
 */
@Mapper
public interface IdempotentMapper {

    int insert(Idempotent idempotent);

    Idempotent selectByRecord(String record);

    int updateOptTime(long optTime, long id);

}
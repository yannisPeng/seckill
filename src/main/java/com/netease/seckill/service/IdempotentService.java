/**
 * @(#)IdempotentService.java, 2019/8/22.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.service;

import com.netease.seckill.po.Idempotent;

/**
 * @author 彭羽(wb.pengyu @ mesg.corp.netease.com)
 */
public interface IdempotentService {

    int insert(Idempotent idempotent);

    Idempotent selectByRecord(String record);

    int updateOptTime(long id);

}
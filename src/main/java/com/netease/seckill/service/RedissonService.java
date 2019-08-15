/**
 * @(#)RedissonService.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.service;

import org.redisson.api.RLock;

/**
 * @author 彭羽(wb.pengyu @ mesg.corp.netease.com)
 */
public interface RedissonService {

    RLock getRLock(String recordId);

}

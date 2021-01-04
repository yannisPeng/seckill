/**
 * @(#)RedissonService.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.net.seckill.service;

import org.redisson.api.RLock;

public interface RedissonService {

    RLock getRLock(String recordId);

}

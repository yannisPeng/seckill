/**
 * @(#)TranscationalService.java, 2019/8/22.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.netease.seckill.exception.SecKillException;

/**
 * @author 彭羽(wb.pengyu @ mesg.corp.netease.com)
 */
@Service
public class TranscationalService {

    @Transactional(propagation = Propagation.NESTED)
    public void trnsactionalTest() {
        throw new SecKillException("业务异常");
    }

}
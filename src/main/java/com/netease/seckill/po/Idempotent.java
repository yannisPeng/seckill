/**
 * @(#)Idempotent.java, 2019/8/19.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.po;

import lombok.Data;

/**
 * @author 彭羽(pengyu@corp.netease.com)
 */
@Data
public class Idempotent {

    private long id;

    private String record;

    private String tag;

    private long optTime;

}
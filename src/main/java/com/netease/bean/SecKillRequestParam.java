/**
 * @(#)vo.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.bean;

import lombok.Data;

/**
 * @author 彭羽(pengyu@corp.netease.com)
 */
@Data
public class SecKillRequestParam {

    private long userId;

    private long skuId;

    private long itemId;

}
/**
 * @(#)StockService.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.service;

/**
 * @author 彭羽(pengyu @ .corp.netease.com)
 */
public interface StockService {

    boolean deductionStock(long skuId) throws InterruptedException;

    int getTotalStock(long skuId) throws InterruptedException;

}

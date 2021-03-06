/**
 * @(#)StockService.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.net.seckill.service;

public interface StockService {

    boolean deductionStock(long skuId,long userId) throws InterruptedException;

    int getTotalStock(long skuId) throws InterruptedException;

    String getTotalStock();

    void dealInfo(String info) throws Exception;


}

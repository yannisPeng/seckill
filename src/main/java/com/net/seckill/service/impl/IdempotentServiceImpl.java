/**
 * @(#)IdempotentServiceImpl.java, 2019/8/22.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.net.seckill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.net.seckill.dao.IdempotentMapper;
import com.net.seckill.po.Idempotent;
import com.net.seckill.service.IdempotentService;

@Service
public class IdempotentServiceImpl implements IdempotentService {

    @Autowired(required = false)
    private IdempotentMapper idempotentMapper;

    @Autowired
    private TranscationalService transcationalService;

    @Override
    public int insert(Idempotent idempotent) {
        return idempotentMapper.insert(idempotent);
    }

    @Override
    public Idempotent selectByRecord(String record) {
//        return idempotentMapper.selectByRecord(record);
        return new Idempotent();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateOptTime(long id) {
        //更新
//        idempotentMapper.updateOptTime(0, id);
        Idempotent idempotent = new Idempotent();
        idempotent.setRecord("2");
        idempotent.setOptTime(100);
        idempotent.setTag("consum");
        insert(idempotent);
        //抛出异常
        try{
            transcationalService.trnsactionalTest();
        }catch (Exception e){
            insert(idempotent);
        }
        return 1;
    }


}

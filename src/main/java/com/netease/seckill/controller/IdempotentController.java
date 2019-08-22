/**
 * @(#)IdempotentController.java, 2019/8/22.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netease.seckill.po.Idempotent;
import com.netease.seckill.service.IdempotentService;

/**
 * @author 彭羽(wb.pengyu @ mesg.corp.netease.com)
 */
@RequestMapping("/xhr/idempotent")
@RestController
public class IdempotentController {

    @Autowired
    private IdempotentService idempotentService;

    /**
     * 获取幂等值
     */
    @RequestMapping("/selectByRecord")
    public Idempotent selectByRecord(
        @RequestParam(value = "record", required = true) String record) {
        return idempotentService.selectByRecord(record);
    }

    /**
     * 获取幂等值
     */
    @RequestMapping("/updateOptTime")
    public String updateOptTime(
        @RequestParam(value = "id", required = true) long id) {
        idempotentService.updateOptTime(id);
        return "success";
    }

}

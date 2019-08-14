/**
 * @(#)SecKillController.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netease.bean.SecKillRequestParam;

/**
 * @author 彭羽(pengyu@corp.netease.com)
 */
@Controller
@RequestMapping("/xhr/seckill")
public class SecKillController {

    @RequestMapping("bugGoods")
    public String buyGoods(@RequestBody SecKillRequestParam param){

        return "success";
    }

}
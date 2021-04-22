package com.net.seckill.controller;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/4/14
 */
@RestController
@RequestMapping("/deferredResult")
public class DeferredResultController {

    /**
     * 一个集群对应一个长连接
     */
    private Multimap<String, DeferredResult<String>> multiMap = Multimaps.synchronizedMultimap(HashMultimap.create());

    private DeferredResult<String> deferredResult = new DeferredResult<>();

    /**
     * 长轮询
     * @return
     */
    @RequestMapping(value = "/holdLongPolling")
    public DeferredResult<String> holdLongPolling() {
        deferredResult.onCompletion(new Runnable() {
            @Override
            public void run() {
                System.out.println("进入deferredResult");
            }
        });
        return deferredResult;
    }

    /**
     * 配置变更
     * @return
     */
    @RequestMapping(value = "/configChange")
    public String configChange() {
        deferredResult.setResult("已变更");
        return "change";
    }

}

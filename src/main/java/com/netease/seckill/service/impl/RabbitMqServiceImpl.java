package com.netease.seckill.service.impl;

import com.netease.seckill.service.RabbitMqService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author 10014994
 * @date 2020/5/18
 */
@Service
public class RabbitMqServiceImpl implements RabbitMqService {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolExecutorRabbitMq;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    @Async("threadPoolExecutorRabbitMq")
    public String sendMsg() {
        rabbitTemplate.convertAndSend("testAck", null, "success");
        return String.valueOf(threadPoolExecutorRabbitMq.getActiveCount());
    }

}

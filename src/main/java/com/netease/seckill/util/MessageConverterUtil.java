package com.netease.seckill.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.nio.charset.StandardCharsets;

/**
 * rabbitmq消息转换工具类
 * 不推荐使用{@link RabbitTemplate#convertAndSend(String, String, Object)}方法
 * 统一使用send方法，通过该工具类定义转换规则
 *
 * @Author: lnn
 * @Date: 2020/4/24 16:09
 */
public class MessageConverterUtil {

    private static final Logger logger = LoggerFactory.getLogger(MessageConverterUtil.class);

    /**
     * 接收转换，统一转成string
     *
     * @param message
     * @return
     */

    public static String fromAmqpMessage(Message message) throws Exception {
        String result = null;
        result = new String(message.getBody(), StandardCharsets.UTF_8);

        return result;
    }


}

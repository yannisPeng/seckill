package com.net.seckill.mq;

import com.net.seckill.service.StockService;
import com.net.seckill.util.MessageConverterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author 10014994
 * @date: 2020/4/28
 */
@Component
public class MqConsumer {

    private static Logger logger = LoggerFactory.getLogger(MqConsumer.class);

    @Autowired
    private StockService stockService;

//    @RabbitListener(queues = "testAckQueue")
    public void processMessage(Message message) throws Exception {
        String result = null;
        result = MessageConverterUtil.fromAmqpMessage(message);
        stockService.dealInfo(result);
    }

}

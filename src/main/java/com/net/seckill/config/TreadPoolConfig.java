package com.net.seckill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Description: 多线程配置文件
 *
 * @author 10014994
 * @date 2020/5/18
 */
@Configuration
public class TreadPoolConfig{


    @Bean(name = "threadPoolExecutorRabbitMq")
    public ThreadPoolTaskExecutor ThreadPoolExecutorRabbitMq() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setThreadNamePrefix("RabbitMq-");
        executor.setKeepAliveSeconds(20);
        executor.initialize();
        return executor;
    }

}

package com.net.seckill;

import com.net.seckill.delay.*;
import com.net.seckill.delay.persistence.TaskDao;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter({TaskDao.class})
public class MySqlTaskManagerAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(TaskManager.class)
    @ConditionalOnBean({TaskProperties.class})
    public MySqlTaskManager mySqlTaskManager(TaskProperties taskProperties) {
        MySqlTaskManager taskManager = new MySqlTaskManager(taskProperties, new TaskDao("", null));
        taskManager.start();
        return taskManager;
    }
}

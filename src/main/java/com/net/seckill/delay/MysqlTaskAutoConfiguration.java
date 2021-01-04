package com.net.seckill.delay;

import com.net.seckill.delay.persistence.MysqlTaskScheduler;
import com.net.seckill.delay.persistence.TaskDao;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Description: mysql自动装配
 *
 * @author 10014994
 * @since 2020/11/15
 */
@Configuration
@EnableConfigurationProperties(EmbedTaskProperties.class)
public class MysqlTaskAutoConfiguration implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Bean
    @ConditionalOnMissingBean
    public TaskDao taskDao(EmbedTaskProperties properties){
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        if (properties.getDatasource() != null && properties.getDatasource().length() > 0) {
            dataSource = applicationContext.getBean(properties.getDatasource(), DataSource.class);
        }
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        TaskDao taskDao = new TaskDao(properties.getTableName(), jdbcTemplate);
        return taskDao;
    }

    @Bean
    @ConditionalOnMissingBean
    public MysqlTaskScheduler mysqlTaskSchedule(TaskDao taskDao) {
        MysqlTaskScheduler scheduler = new MysqlTaskScheduler();
        scheduler.setTaskDao(taskDao);
        return scheduler;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

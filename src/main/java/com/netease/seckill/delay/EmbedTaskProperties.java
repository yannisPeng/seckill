package com.netease.seckill.delay;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/11/15
 */
@ConfigurationProperties("task.mysql")
@Data
public class EmbedTaskProperties {

    /**
     * 指定数据源名称
     */
    private String datasource = "";

    /**
     * 指定表名
     */
    private String tableName = "delay_task";

    /**
     * 抓取待处理任务的时间间隔 秒
     */
    private Integer fetchPeriodSeconds = 20;

    /**
     * 抓取超时任务的间隔 秒
     */
    private Integer fetchTimeoutPeriodSeconds = 90;

    /**
     * 对于同一时期的大批量的数据，不保证一定在约定的时间执行
     * 单个周期内处理的task最大数量，超过此值的任务，将延后到下一个周期执行
     */
    private Integer maxTaskCountOnePeriod = 30000;

    /**
     * 执行任务的线程池大小
     */
    private Integer poolSize = 15;

    /**
     * 任务的缓冲队列大小
     */
    private Integer queueSize = 10000;


    /**
     * 日志规模
     * DETAIL 所有日志
     * NORMAL 正常
     * LESS 最少
     */
    private LogScale logScale = LogScale.NORMAL;


    /**
     * 尝试执行任务时，锁定任务的随机时间，减少对数据库锁的并发压力
     * 默认没有此设置
     * 如果启用了 EadisMysqlTaskManager 则会启用分布式锁，不需要此设置
     *
     */
    private Integer randomDelayMs = 0;


    public enum LogScale {
        DETAIL, NORMAL, LESS
    }

}

package com.netease.seckill.delay.core;

import com.netease.seckill.delay.persistence.TaskParam;

/**
 * Description: 任务调度器
 *
 * @author 10014994
 * @since 2020/11/15
 */
public interface TaskScheduler {

    /**
     * 延时任务
     *
     * @param scheduleTask
     * @param taskParam
     * @param delaySeconds
     * @return
     */
    String doDelaySchedule(Class<? extends DelayTask> scheduleTask, TaskParam taskParam, int delaySeconds);


}

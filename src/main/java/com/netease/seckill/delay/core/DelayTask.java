package com.netease.seckill.delay.core;

import com.netease.seckill.delay.persistence.TaskParam;

/**
 * Description: 延时任务
 *
 * @author 10014994
 * @since 2020/11/15
 */
public interface DelayTask<T extends TaskParam> {

    void doDelayTask(TaskParam taskParam);

    default TaskCodec taskCodec() {
        return JdkTaskCodec.INSTANCE;
    }

}

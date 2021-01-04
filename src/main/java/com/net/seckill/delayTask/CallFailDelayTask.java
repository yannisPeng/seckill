package com.net.seckill.delayTask;

import com.net.seckill.delay.core.DelayTask;
import com.net.seckill.delay.persistence.TaskParam;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/11/15
 */
public class CallFailDelayTask implements DelayTask {

    @Override
    public void doDelayTask(TaskParam taskParam) {
        System.out.println("延时任务执行成功");
    }

}

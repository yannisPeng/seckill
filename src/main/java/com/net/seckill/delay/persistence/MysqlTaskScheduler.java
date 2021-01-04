package com.net.seckill.delay.persistence;

import com.net.seckill.delay.core.DelayTask;
import com.net.seckill.delay.core.TaskScheduler;
import com.net.seckill.delay.persistence.util.BeanUtil;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/11/15
 */
public class MysqlTaskScheduler implements TaskScheduler {

    private TaskDao taskDao;

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public String doDelaySchedule(Class<? extends DelayTask> scheduleTask, TaskParam taskParam, int delaySeconds) {
        DelayTask task = BeanUtil.getInstance(scheduleTask);
        if(task.taskCodec() == null){
            throw new IllegalArgumentException("没有指定序列化方式" + scheduleTask.getClass());
        }
        Date execDate = DateUtils.addSeconds(new Date(), delaySeconds);
        long id = taskDao.newTask(scheduleTask, taskParam, execDate, task);
        return String.valueOf(id);
    }

}

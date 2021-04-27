package com.net.seckill.delay;

import com.net.seckill.delay.persistence.TaskDao;

public class MySqlTaskManager implements TaskManager{

    private TaskProperties taskProperties;

    private TaskDao taskDao;

    private volatile Boolean STARTED = false;

    public MySqlTaskManager(TaskProperties taskProperties, TaskDao taskDao) {
        this.taskProperties = taskProperties;
        this.taskDao = taskDao;
    }

    @Override
    public void start() {
        if(!STARTED){
           return;
        }
    }
}

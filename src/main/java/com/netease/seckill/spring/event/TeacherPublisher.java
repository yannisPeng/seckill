package com.netease.seckill.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Description: 作业发布者
 *
 * @author 10014994
 * @since 2020/7/15
 */
@Component
public class TeacherPublisher{

    @Autowired
    private ApplicationContext applicationContext;

    public void publishHomeWork(String content){
        TeacherHomeworkEvent teacherHomeworkEvent = new TeacherHomeworkEvent(this,content);
        applicationContext.publishEvent(teacherHomeworkEvent);
    }

}

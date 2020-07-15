package com.netease.seckill.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Description: B学生
 *
 * @author 10014994
 * @since 2020/7/15
 */
@Component
public class StudentBListener implements ApplicationListener<TeacherHomeworkEvent> {

    @Override
    public void onApplicationEvent(TeacherHomeworkEvent teacherHomeworkEvent) {
        System.out.println("Student-B do homework :" + teacherHomeworkEvent.getContent());
    }

}

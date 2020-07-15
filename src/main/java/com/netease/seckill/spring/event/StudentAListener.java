package com.netease.seckill.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Description: A学生
 *
 * @author 10014994
 * @since 2020/7/15
 */
@Component
public class StudentAListener implements ApplicationListener<TeacherHomeworkEvent> {

    @Override
    public void onApplicationEvent(TeacherHomeworkEvent teacherHomeworkEvent) {
        System.out.println("Student-A do homework :" + teacherHomeworkEvent.getContent());
    }

}

package com.net.seckill.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * Description: 老师布置作业
 *
 * @author 10014994
 * @since 2020/7/15
 */
public class TeacherHomeworkEvent extends ApplicationEvent {

    private String content;

    public TeacherHomeworkEvent(Object source, String content) {
        super(source);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

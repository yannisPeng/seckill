package com.netease.seckill.po;

import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/6/22
 */
public class StudentService {

    private String name;

    public String sayHi() {
        return "hi";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

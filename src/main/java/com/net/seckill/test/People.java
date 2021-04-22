/**
 * @(#)People.java, 2020/2/19.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.net.seckill.test;

import lombok.Data;

/**
 * @Title: People
 * @Description:
 * @Date 2020/2/19 16:54
 * @Version v1.0
 */
@Data
public class People implements Comparable{

    private String name = "张三";

    private Integer age = 10;

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
package com.net.seckill.po;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/8/3
 */
public class Student implements Serializable {

    private String name;

    private List<String> attrs;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<String> attrs) {
        this.attrs = attrs;
    }
}

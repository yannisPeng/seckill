package com.net.seckill.po;

import com.net.seckill.test.BigDecimalTest;
import com.net.seckill.test.OneAction;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/8/3
 */
public class Student extends BigDecimalTest implements Serializable {

    private String name = "张三";

    private List<String> attrs;

    public Student() {
    }

    static {
        System.out.println("进入Student静态代码块");
    }

    public Student(String name) {
        this.name = name;
    }

    private String getName() {
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

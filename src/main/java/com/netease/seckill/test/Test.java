package com.netease.seckill.test;

import com.alibaba.fastjson.JSON;
import com.netease.seckill.service.RedissonService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author 10014994
 * @date: 2020/5/11
 */
public class Test {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(JSON.toJSONString(list.stream().filter(lists -> lists.equals("a")).collect(Collectors.toList())));

        System.out.println(new BigDecimal(0.00));

    }

}

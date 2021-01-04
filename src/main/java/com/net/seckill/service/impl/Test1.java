package com.net.seckill.service.impl;

import com.net.seckill.service.TestInterface;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/11/14
 */
@Service
public class Test1 implements TestInterface {

    @Override
    public String doThings() {
        return "test1";
    }

    public static void main(String[] args) {
        int[] a = {1};
        System.out.println(a[2]);
    }

}

package com.netease.seckill.test;

import java.math.BigDecimal;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/10/20
 */
public class BigDecimalTest {

    public static void main(String[] args) {

        BigDecimal bigDecimal = new BigDecimal("0");
        for (int i = 0; i < 1; i++) {
            bigDecimal = bigDecimal.add(new BigDecimal("20.00"));
        }

        System.out.println(bigDecimal);

    }

}

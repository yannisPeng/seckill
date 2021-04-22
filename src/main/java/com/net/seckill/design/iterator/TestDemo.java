package com.net.seckill.design.iterator;

import java.util.ArrayList;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/1/22
 */
public class TestDemo {

    public static void main(String[] args) {

        NameContainer<Integer> nameContainer = new NameContainer<>(new ArrayList());

        System.out.println(nameContainer.getIterator().hashNext());

    }

}

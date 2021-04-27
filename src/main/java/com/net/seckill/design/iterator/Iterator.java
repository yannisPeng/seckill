package com.net.seckill.design.iterator;

/**
 * Description: 迭代器接口
 *
 * @author 10014994
 * @since 2021/1/22
 */
public interface Iterator<T> {

    boolean hashNext();

    T next();

}

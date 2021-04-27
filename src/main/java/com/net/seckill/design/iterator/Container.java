package com.net.seckill.design.iterator;

/**
 * Description: 容器接口
 *
 * @author 10014994
 * @since 2021/1/22
 */
public interface Container<T> {

    Iterator<T> getIterator();

}

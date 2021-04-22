package com.net.seckill.design.iterator;

import java.util.List;

/**
 * Description: 容器
 *
 * @author 10014994
 * @since 2021/1/22
 */
public class NameContainer<T> implements Container<T>{

    private List<T> t;

    public NameContainer(List<T> t) {
        this.t = t;
    }

    @Override
    public Iterator<T> getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator<T>{

        int index;

        @Override
        public boolean hashNext() {
            return index < t.size();
        }

        @Override
        public T next() {
            return t.get(index);
        }
    }

}

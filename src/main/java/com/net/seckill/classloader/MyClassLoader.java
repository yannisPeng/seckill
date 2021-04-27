package com.net.seckill.classloader;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/4/13
 */
public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}

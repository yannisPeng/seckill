package com.net.seckill.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.List;

/**
 * Description:
 *
 * @author 10014994
 * @date: 2020/5/11
 */
public class Test extends ClassLoader implements OneAction{

    People people = new People();

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    public static void main(String[] args) throws InterruptedException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IOException {

        Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("com.net.seckill.po.Student");
        Method[] method = aClass.getDeclaredMethods();
        Method[] methods = aClass.getMethods();

        Socket socket = new Socket("127.0.0.1", 8080);


    }

    public void testInterfaceStatic(){

    }



    public void test1() throws InterruptedException {
        synchronized (people) {
            people.wait();
            System.out.println("wait");
        }
    }

    public void test2(List<String> str) {
        synchronized (people) {
            people.notify();
        }
    }

    public static class A extends Test{

        private static String name;

    }

}

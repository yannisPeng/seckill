package com.net.seckill.test;

import com.net.seckill.service.impl.Test1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.rmi.AccessException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author 10014994
 * @date: 2020/5/11
 */
public class Test extends ClassLoader implements OneAction {

    People people = new People();

    Object[] abc = new Object[10];

    volatile Test1 count = new Test1();

    public void init() {
        abc[0] = count;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    private static Object objectLockA = new Object();

    public static void m1() {
        new Thread(() -> {
            synchronized (objectLockA) {
                System.out.println("外");
                synchronized (objectLockA) {
                    System.out.println("内");
                }
            }
        }, "").start();
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set(1);
        threadLocal.get();

    }

    public void testInterfaceStatic() {

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

    public static class A extends Test {

        private static String name;

    }

}

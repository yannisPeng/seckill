package com.net.seckill.up;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/11/12
 */
@Service
public class Test implements BeanPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private Map<String, Action> actionList;

    public Test() {
        System.out.println("初始化bean");
    }

    @PostConstruct
    public void init(){
        System.out.println();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("起床");
            }
        });
        Thread thread2 = new Thread(new Runnable(){
            @SneakyThrows
            @Override
            public void run() {
                thread1.join();
                System.out.println("穿衣服");
            }
        });
        Thread thread3 = new Thread(new Runnable(){
            @SneakyThrows
            @Override
            public void run() {
                thread2.join();
                System.out.println("洗漱");
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("after");
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("before");
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

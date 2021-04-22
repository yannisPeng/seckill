package com.net.seckill.up;

import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.table.TableCellEditor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/11/12
 */
public class Test extends Action{

    private AtomicInteger atomicInteger = new AtomicInteger(10);

    private static int i = 1;

    public Test() {
        super();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set(1);
        threadLocal.get();
    }

    public static void doSomeT(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        List<Throwable> throwableList = new ArrayList<>();

        List<CompletableFuture<Boolean>> completableFutureList = new ArrayList<>();
        final CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(() -> doSomeThing(executorService));
        completableFutureList.add(future);
        for(CompletableFuture future1 : completableFutureList){
            future1.exceptionally((e) -> throwableList.add((Throwable) e));
        }
        System.out.println(1);
    }

    private static Boolean doSomeThing(ExecutorService executorService) {
        throw new RuntimeException();
    }

    public Object call(){
        i = 2;
        System.out.println(atomicInteger.getAndIncrement());
        return null;
    }

    @Override
    public void payMoney(Money money) {

    }
}

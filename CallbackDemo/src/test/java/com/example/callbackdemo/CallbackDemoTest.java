package com.example.callbackdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 1.尝试一个对象传递给线程，当线程出错时，这个对象是否被回收（遇到过DataSource在新线程异常时，DataSource再使用时断连）
 * 2.尝试run和call方法的异常抛出
 * 3.记：父方法抛出异常子方法可以抛也可以不抛，父方法不抛，子方法重写时不能抛；
 */
@Slf4j
public class CallbackDemoTest {
    /**
     * 执行到【业务代码】，后续遇到除零报错
     * Exception in thread "Thread-0" java.lang.ArithmeticException: / by zero
     */
    @Test
    public void testRun() {
        Runnable runnable = () -> {
            log.info("Runnable start...");
            log.info("Runnable 业务代码！");
            int a = 1 / 0;
            log.info("Runnable end.");
        };

        new Thread(runnable).start();
    }

    /**
     * 执行到到【业务代码】，后续无反应
     */
    @Test
    public void testCall() {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            log.info("Callback start...");
            log.info("Callback 业务代码！");
            int a = 1 / 0;
            log.info("Callable end.");
            return a;
        });

        new Thread(task).start();
    }
}

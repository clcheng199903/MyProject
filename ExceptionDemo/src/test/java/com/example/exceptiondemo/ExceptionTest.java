package com.example.exceptiondemo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ExceptionTest {

    /**
     * java.lang.ArithmeticException: / by zero
     */
    @Test
    public void testException() {
        int a = 1 / 0;
    }

    /**
     * java.lang.ArithmeticException: / by zero
     */
    @Test
    public void testThrowable() {
        throwE();
    }

    /**
     * java.lang.ArithmeticException: / by zero
     */
    @Test
    public void testRunDirectly() {
        Runnable runnable = () -> {
            int a = 1 / 0;
        };

        runnable.run();
    }


    /**
     * V call() throws Exception;
     *
     * call()方法抛出异常，当调用时必须显式捕获
     */
    @Test
    public void testCallDirectly() {
        Callable<Integer> callable = () -> {
            int a = 1 / 0;
            return a;
        };

        try {
            callable.call();
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }
    }

    /**
     * Exception in thread "Thread-0" java.lang.ArithmeticException: / by zero
     */
    @Test
    public void testRun() {
        Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("run");
            int a = 1 / 0;
        };

        new Thread(runnable).start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int a = 1 / 0;
        log.info("main end!");
    }

    /**
     * 无输出
     */
    @Test
    public void testCall() {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            int a = 1 / 0;
        }, 0);
        new Thread(task).start();
    }

    /**
     * 多线程的异常，并不会对共享变量造成影响，对象的管理还是由GC决策
     */
    @Test
    public void testObj() {
        Person person = new Person();
        person.setId(4);
        new Thread(() -> {
            Integer id = person.getId();
            log.info("id: {}", id);
            int a = 1 / 0;
        }).start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {

        }
        log.info("id: {}", person.getId());
    }

    /**
     * ArithmeticException 算术异常是运行时异常，调用方法不需要异常捕获
     * @throws ArithmeticException
     */
    public void throwE() throws ArithmeticException {
        int a = 1 / 0;
    }

    @Data
    public class Person {
        private Integer id;
    }

}

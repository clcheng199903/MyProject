package com.example.threadpooldemo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class JDKTest {

    @Test
    public void testThreadPool() {

    }


    /**
     * Executors工厂类
     * Factory and utility methods for Executor, ExecutorService, ScheduledExecutorService, ThreadFactory, and Callable classes defined in this package
     *
     * 1.ExecutorService: An Executor that provides methods to manage termination and methods that can produce a Future for tracking progress of one or more asynchronous tasks.
     * 2.ScheduledExecutorService: An ExecutorService that can schedule commands to run after a given delay, or to execute periodically.
     *
     * ExecutorService是管理异步任务的
     * ScheduledExecutorService能定时或周期执行任务
     */
    @Test
    public void testExecutorService() {
        // 这种线程池是一个
        ExecutorService pool = Executors.newFixedThreadPool(10);

        // ScheduledExecutorService -> ExecutorService
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);

    }

    /**
     * ExecutorService
     * ScheduledExecutorService -> ExecutorService
     */
    @Test
    public void testThreadPoolExecutor() {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        // ExecutorService
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS, queue);

        // ThreadPoolExecutor - ScheduledExecutorService
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);
    }

    @Test
    public void testThreadFactory() {
        /**
         * 线程工厂类
         */
        ThreadFactory threadFactory = new ThreadFactory() {
            AtomicInteger count = new AtomicInteger();
            @Override
            public Thread newThread(Runnable r) {

                return new Thread(r, "thread-" + count.getAndIncrement());
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(5, threadFactory);
        pool.execute(()-> System.out.println(Thread.currentThread().getName()));
        pool.execute(()-> System.out.println(Thread.currentThread().getName()));
        pool.execute(()-> System.out.println(Thread.currentThread().getName()));
        pool.execute(()-> System.out.println(Thread.currentThread().getName()));
        pool.execute(()-> System.out.println(Thread.currentThread().getName()));
    }
}

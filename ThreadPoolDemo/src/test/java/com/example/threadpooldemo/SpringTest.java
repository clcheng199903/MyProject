package com.example.threadpooldemo;

import org.junit.jupiter.api.Test;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

public class SpringTest {
    /**
     * TaskScheduler
     * AsyncTaskExecutor -> TaskExecutor -> Executor
     */
    @Test
    public void testSpring() {
        // AsyncTaskExecutor - TaskScheduler
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        // AsyncTaskExecutor
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // AsyncTaskExecutor
        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
    }

    @Test
    public void testThreadPoolTaskExecutor() {

    }
}

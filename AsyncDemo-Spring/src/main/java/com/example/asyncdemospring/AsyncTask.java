package com.example.asyncdemospring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 向@Scheduled和@Async这种注解，是需要在bean对象中使用的
 * 如果希望获取到异步调用的返回值，需要用Future包装好
 */
@Slf4j
@Component
public class AsyncTask {

    /**
     * @Async使用的是非守护线程
     */
    @Async
    public void taskAsync() {
//        Arrays.stream(new int[]{1,2,3,4,5,6,7,8,9}).forEach(i -> log.info("i: {}, thread: {}", i, Thread.currentThread().getName()));
        log.info("taskAsync: {}", Thread.currentThread().getName());
    }

    @Async
    public void task1Async() {
        log.info("task1Async:{}", Thread.currentThread().getName());
    }
}

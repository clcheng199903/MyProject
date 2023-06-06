package com.example.asyncdemospring.task;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Async
@Component
public class Task {

    @Async
    public void task1() {
        Thread thread = Thread.currentThread();
        log.info(Thread.currentThread().getName());
    }

    /**
     * 这样无效，因为同一个类中调用异步方法不会使用异步操作
     */
    @PostConstruct
    public void init() {
//        task1();
    }
}

package com.example.schedulerdemospring.schedule;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class Task {
    private final static AtomicInteger count = new AtomicInteger(1);

//    @Resource(name = "threadPool")
//    private ExecutorService threadPool;

    @PostConstruct
    public void init() {
//        log.info("ThreadPool shutdown: {}", threadPool.isShutdown());
//        threadPool.submit(() -> log.info(Thread.currentThread().getName())); // pool-2-thread-1,线程名
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void shedule() {
        log.info("线程：{}，执行次数：{}", Thread.currentThread().getName(), count.getAndIncrement()); // scheduling-1线程名,自己的线程不是用的main线程
    }

    @Scheduled(cron = "*/3 * * * * *")
    public void sheduler() {
        log.info("线程：{}，执行次数：{}", Thread.currentThread().getName(), count.get());
    }
}

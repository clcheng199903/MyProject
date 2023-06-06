package com.example.asyncdemospring;

import com.example.asyncdemospring.task.Task;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 实现异步的方式：
 * 1.线程池（多线程）
 * 2.mq方式（业务代码和非业务代码分离，非业务逻辑不会影响到执行业务逻辑的结果和主机性能）
 * 3.Spring注解@EnableAsync和@Async
 */
@EnableAsync
@SpringBootApplication
public class AsyncDemoSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncDemoSpringApplication.class, args);
    }

    @Resource
    private Task task;

    @PostConstruct
    public void init() {
        task.task1();
    }

}

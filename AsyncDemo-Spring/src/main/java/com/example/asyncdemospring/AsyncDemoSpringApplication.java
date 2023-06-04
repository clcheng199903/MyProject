package com.example.asyncdemospring;

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

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.initialize();
        executor.execute(()-> System.out.println(Thread.currentThread().getName()));
    }

    @Resource
    private AsyncTask task;

    /**
     * @Async开启的线程会在一分钟后自动关闭
     */
//    @PostConstruct
//    public void init() {
//        for (int i=0; i<5;i++) {
//            task.taskAsync();
//            task.task1Async();
//        }
//    }

}

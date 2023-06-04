package com.example.schedulerdemospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.CountDownLatch;

@EnableScheduling // 手动启用，要不然@Scheduled注解不生效
@SpringBootApplication
public class SchedulerDemoSpringApplication {

    // 同步
    private final static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(SchedulerDemoSpringApplication.class, args);
        latch.await();
    }

}

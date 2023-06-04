package com.example.schedulerdemospring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ThreadPoolConfig implements SchedulingConfigurer {

//    @Bean
//    public ExecutorService threadPool() {
//        ExecutorService pool = Executors.newFixedThreadPool(10);
//        return pool;
//    }


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        taskRegistrar.setScheduler(Executors.);
    }
}

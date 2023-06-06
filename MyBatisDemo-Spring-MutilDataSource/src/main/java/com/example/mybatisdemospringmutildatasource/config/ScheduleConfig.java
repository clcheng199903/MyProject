package com.example.mybatisdemospringmutildatasource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.ThreadPoolExecutor;

@EnableScheduling
@Configuration
public class ScheduleConfig {
    private static final int PoolSize = 10;       		// 核心线程数（默认线程数）
    private static final String threadNamePrefix = "Schedule-"; // 线程池名前缀

    @Bean("taskScheduler") // bean的名称，默认为首字母小写的方法名
    public ThreadPoolTaskScheduler getScheduleExecutor(){
        ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();

        executor.setPoolSize(PoolSize);
        executor.setThreadNamePrefix(threadNamePrefix);

        // 线程池对拒绝任务的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化
        executor.initialize();
        return executor;
    }

}

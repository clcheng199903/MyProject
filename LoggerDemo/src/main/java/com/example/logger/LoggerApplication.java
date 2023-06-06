package com.example.logger;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class LoggerApplication {

    // Logger实例是根据<logger>创建的，它支持按照包结构继承，并每个层次创建一个logger
    // 如果当前层次未配置<logger>，则匹配上层最近的一个<logger>
//    private static final Logger logger = LoggerFactory.getLogger(LoggerApplication.class);

    public static void main(String[] args) {

//        AnsiConsole

        log.info(Thread.currentThread().getName());
    }
}

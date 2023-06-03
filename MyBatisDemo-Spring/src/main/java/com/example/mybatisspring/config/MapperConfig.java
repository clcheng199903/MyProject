package com.example.mybatisspring.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * SpringBoot具有自动装配的功能，扫描项目下各个@Component被注解类
 */
@Configuration
// 扫描mapper.java类；师兄mapper.xml同样需要指定
@MapperScan("com.example.mybatisspring.mapper")
public class MapperConfig {
}

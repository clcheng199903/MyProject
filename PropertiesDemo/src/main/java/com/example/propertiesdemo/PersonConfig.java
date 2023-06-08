package com.example.propertiesdemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Data
@Configuration
// 可用于@Configuration注解类或者@Bean方法的参数
@ConfigurationProperties(prefix = "person")
public class PersonConfig {
    private String name;
    private Integer age;
    private String sex;

    @Bean
    @ConditionalOnProperty(name = "person.nation", havingValue = "China")
    public PersonConfig getPersonConfig() {
        return this;
    }

    @PostConstruct
    public void print() {
        log.info(this.toString());
//        String property = SpringUtils.getProperty("person.nation");
//        log.info(property);
    }
}

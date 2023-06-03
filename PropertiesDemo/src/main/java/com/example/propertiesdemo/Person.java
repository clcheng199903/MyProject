package com.example.propertiesdemo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@Component
public class Person {
    // @Value用于给field或函数参数赋值
    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private Integer age;
    @Value("${person.sex}")
    private String sex;

    @Value("${person.name}")
    public void sayHello(String name) {
        log.info("hello {}", name);
    }
}

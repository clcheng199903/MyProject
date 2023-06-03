package com.example.propertiesdemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class PropertiesDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertiesDemoApplication.class, args);
    }

    @Resource
    private Person person;
    @Resource
    private Person getPerson;

    @PostConstruct
    public void init() {
        log.info(person.toString());
        person.sayHello("123");
        getPerson.sayHello("llllll");
    }
}

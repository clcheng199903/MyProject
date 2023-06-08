package com.example.propertiesdemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class PropertiesDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertiesDemoApplication.class, args);

        /**
         * 时间在@PostConstruct之后，应该就是整个SpringApplicationContext初始化完毕执行
         * 初始化都是main线程执行
         */
        System.out.println("测试时间节点");
        /**
         * SpringUtils.getProperty()是类方法，而当在@PostContruct中执行时，还未进行上下文赋值，所以获得的context是空值
         */
        String property = SpringUtils.getProperty("person.nation");
        System.out.println(property);
        String[] activeProfiles = SpringUtils.getActiveProfiles();
        // 激活的profile不包括application.yml本身
        System.out.println(Arrays.toString(activeProfiles));

        System.out.println(SpringUtils.getProperty("aB"));
        System.out.println(SpringUtils.getProperty("a-b"));
        boolean married = Boolean.parseBoolean(SpringUtils.getProperty("married"));
        System.out.println(married);
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

//        String nation = SpringUtils.getProperty("person.nation");
//        System.out.println(nation);
    }
}

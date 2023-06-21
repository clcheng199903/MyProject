package com.example.stdspring;

import org.springframework.stereotype.Component;

@Component
public class MyBean {
    public MyBean() {
        System.out.println(MyBean.class.getName());
    }
}

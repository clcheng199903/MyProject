package com.example.mybatisspring.sub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyApplicationTests {
    @Test
    public void contextLoads() {
        System.out.println("hello");
    }

    @Test
    public void test() {
        System.out.println("helo");
        Assertions.assertTrue(() -> true);
    }
}

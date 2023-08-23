package com.example.springsecuritydemo;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CommonTests {
    @Test
    void test() {
        PasswordEncoder encoder = PasswordEncoderFactories
                .createDelegatingPasswordEncoder();

        System.out.println(encoder.encode("password")); // hash运算

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("password");
        System.out.println(password);
    }
}

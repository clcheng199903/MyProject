package com.example.jpademo;

import com.example.jpademo.domain.Account;
import com.example.jpademo.mapper.AccountRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaDemoApplicationTests {

    @Resource
    private AccountRepository repository;

    @Test
    void contextLoads() {
        // 直接根据ID查找
        repository.findById(1).ifPresent(System.out::println);
    }

    @Test
    void addAccount() {
        Account account = new Account();
        account.setId(2); // 主键一致时，会变成更新
        account.setUsername("User");
        account.setPassword("123456");
        Account save = repository.save(account); // 存储
        System.out.println(save);
    }

    @Test
    void selectAccount() {
        Optional<Account> ccl = repository.findById(1);
        System.out.println(ccl.get());

        List<Account> all = repository.findAll();
        System.out.println(all);
    }
}

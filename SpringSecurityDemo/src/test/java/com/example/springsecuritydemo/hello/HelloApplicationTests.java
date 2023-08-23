package com.example.springsecuritydemo.hello;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloApplicationTests {

    @Resource
    private MockMvc mockMvc;

    @Test
    void indexThenOk() throws Exception {
        this.mockMvc.perform(get("/hello"))
                .andExpect(status().isOk());    // 返回401，登录未授权
    }
}

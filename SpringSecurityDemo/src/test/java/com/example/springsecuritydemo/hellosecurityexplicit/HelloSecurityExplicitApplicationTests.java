package com.example.springsecuritydemo.hellosecurityexplicit;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloSecurityExplicitApplicationTests {
    @Resource
    private MockMvc mockMvc;

    @Test
    void indexWhenUnAuthenticatedThenRedirect() throws Exception {
        this.mockMvc.perform(get("/hellosecurityexplicit"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser
    void indexWhenAuthenticatedThenOk() throws Exception {
        this.mockMvc.perform(get("/hellosecurityexplicit"))
                .andExpect(status().isOk());
    }
}

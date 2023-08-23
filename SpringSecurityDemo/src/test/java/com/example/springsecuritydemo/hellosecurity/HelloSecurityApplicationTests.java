package com.example.springsecuritydemo.hellosecurity;

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
public class HelloSecurityApplicationTests {
    @Resource
    private MockMvc mockMvc;

    @Test
    void indexWhenUnAuthenticatedThenRedirect() throws Exception {
        this.mockMvc.perform(get("/hellosecurity"))
                .andExpect(status().isUnauthorized());  // Using generated security password: efa9281a-49ce-4fa1-904b-5a621f72a1f1
    }

    @Test
    @WithMockUser
    void indexWhenAuthenticatedThenOk() throws Exception {
        // @formatter:off
        this.mockMvc.perform(get("/hellosecurity"))
                .andExpect(status().isOk());
        // @formatter:on
    }
}

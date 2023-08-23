package com.example.springsecuritydemo.hellosecurityexplicit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloSecurityExplicitController {
    @GetMapping("/hellosecurityexplicit")
    public String index() {
        return "hello-security-explicit";
    }
}

package com.example.springsecuritydemo.hellosecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloSecurityController {
    @GetMapping("/hellosecurity")
    public String index() {
        return "hello-security";
    }
}

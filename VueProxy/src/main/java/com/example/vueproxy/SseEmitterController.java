package com.example.vueproxy;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(params = "sse/test")
public class SseEmitterController {
    @Resource
    private SseEmitterService service;

    /**
     * 创建新连接
     */
    @GetMapping(path = "start")
    public Object createSession() {
        return service.createSession();
    }

    /**
     * 断开连接
     * @param clientId
     */
    @GetMapping(path = "close")
    public void closeSession(@RequestParam String clientId) {
        service.closeSession(clientId);
    }
}

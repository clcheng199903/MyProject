package com.example.vueproxy;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//@CrossOrigin
//@RestController
public class SSEController {

    private final Map<String, SseEmitter> sseEmitterMap = new ConcurrentHashMap<>();

    // 推送信息data: msg \n\n
    @PostConstruct
    private void init() {
        Executors.newScheduledThreadPool(10).scheduleWithFixedDelay(() -> {
            System.out.println("sseEmitterMap#" + sseEmitterMap);
            sseEmitterMap.forEach((s, sseEmitter) -> {
                try {
                    sseEmitter.send(SseEmitter.event()
                            .id(UUID.randomUUID().toString())
                            .data("hello world!")
                            .reconnectTime(3000L)
                            .comment("this is comment")
                    );
                    if (LocalDateTime.now().getSecond() % 2 == 0) {
                        sseEmitter.send(
                                SseEmitter.event()
                                        .id("1")
                                        .name("customEventName")
                                        .data("customData")
                        );
                    }
                } catch (IOException e) {
                    System.out.println("Error#" + e);
//                    sseEmitter.completeWithError(e);
                }
            });
        }, 3, 3, TimeUnit.SECONDS);
    }

    @GetMapping("/test/sse")
    public SseEmitter sseEmitter(@RequestParam("uid") String uid) throws IOException {
        SseEmitter sseEmitter = new SseEmitter(-1L);
        sseEmitter.send(SseEmitter.event().id("1").name("Connected").data(LocalDateTime.now()).reconnectTime(3000));
        sseEmitterMap.put(uid, sseEmitter);

        sseEmitter.onCompletion(() -> {
            System.out.println(LocalDateTime.now() + ", uid#" + uid + ", on completion");
            sseEmitterMap.remove(uid);
        });
        sseEmitter.onTimeout(() -> System.out.println(LocalDateTime.now() + ", uid#" + uid + ", on timeout#" + sseEmitter.getTimeout()));
        sseEmitter.onError(throwable -> System.out.println(LocalDateTime.now() + ", uid#" + uid + ", on error#" + throwable.toString()));
        return sseEmitter;
    }
}

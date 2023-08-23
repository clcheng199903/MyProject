package com.example.vueproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
public class SseEmitterService {
    public static final Map<String, SseEmitter> SSE_CACHE = new ConcurrentHashMap<>();
    public static final Logger logger = LoggerFactory.getLogger(SseEmitterService.class);


    /**
     * 创建新连接
     */
    public synchronized SseEmitter createSession() {
        SseEmitter sseEmitter  = new SseEmitter(0L); // 过期时间设置为0，表示永不过期
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        if (!SSE_CACHE.containsKey(id)) {
            SSE_CACHE.put(id, sseEmitter);
            logger.info("客户端{}新建连接成功，当前客户端总数为{}", id, SSE_CACHE.size());
        }
        return sseEmitter;
    }

    /**
     * 关闭连接
     * @param clientId
     */
    public void closeSession(String clientId) {
        if (SSE_CACHE.containsKey(clientId)) {
            SSE_CACHE.get(clientId).complete();
            SSE_CACHE.remove(clientId);
            logger.info("客户端{}断开成功，当前剩余客户端总数为{}", clientId, SSE_CACHE.size());
        }
    }

    /**
     * 定时任务
     */
    @Scheduled(fixedDelay = 3, initialDelay = 1, timeUnit = TimeUnit.SECONDS)
    public void job() {
        if (SSE_CACHE.size() > 0) {
            String msg = UUID.randomUUID().toString();
            System.out.println("msg = " + msg);
            for (Map.Entry<String, SseEmitter> entry : SSE_CACHE.entrySet()) { // 变量SseEmitter
                SseEmitter sseEmitter = SSE_CACHE.get(entry.getKey());
                try {
                    // 向客户端发送消息，包括id和数据
                    sseEmitter.send(SseEmitter.event().reconnectTime(1000).id(entry.getKey()).data(msg));
                } catch (Exception e) {
                    SSE_CACHE.remove(entry.getKey());
                }
            }
        }
    }

}

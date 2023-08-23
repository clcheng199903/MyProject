package com.example.wsdemo;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 每创建一个连接都会初始化这个类
 */
@ServerEndpoint(value = "/api/websocket/{user_id}")
@Component
@Slf4j
public class WebSocketServer {
    private String userId;

    /**
     * 建立连接
     * @param session
     * @param userId
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("user_id") String userId) { // 方法参数是固定写法
        this.userId = userId;
        log.info("{}连接成功", userId);
    }

    /**
     * 接收消息
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("{}接收消息：{}", userId, message);
        try {
            session.getBasicRemote().sendText(userId + "服务端收到消息");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 连接断开
     */
    @OnClose
    public void onClose() {
        log.info("{}连接断开", userId);
    }
}

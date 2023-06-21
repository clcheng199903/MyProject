package com.example.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 阻塞队列：解决多个生产者和多个消费者数据共享的问题和超市唤醒问题
 */
public class BQDemo {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);
        new Thread(() -> {
            /**
             * 取值并移除，队列为空时返回null
             */
            String poll = queue.poll();// 立刻取值
            System.out.println("1: " + poll);
        }).start();

        new Thread(() -> {
            /**
             * 入值，队列满时返回false，值丢失
             */
            boolean hello = queue.offer("hello");
            System.out.println("2: " + hello);
        }).start();
        new Thread(() -> {
            String poll = queue.poll();
            System.out.println("3: " + poll);
        }).start();
    }
}

package com.example.callbackdemo;

import com.example.callbackdemo.guava.AsyncListenUtil;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * Test线程相当于Main线程，他强制将其它线程变为守护线程，当主线程执行完毕就自动销毁其它所有线程
 */
public class GuavaTest {
    @Test
    public void test() throws InterruptedException {
        AsyncListenUtil.submit(() -> {
            TimeUnit.SECONDS.sleep(5); // 这个异常线程callback会自己捕获
                    System.out.println(Thread.currentThread().getName());
            return "任务执行结束";
        }, (r) -> System.out.println("任务成功执行" + Thread.currentThread().getName())
        ,(e) -> e.printStackTrace());

        TimeUnit.SECONDS.sleep(10);
    }
}

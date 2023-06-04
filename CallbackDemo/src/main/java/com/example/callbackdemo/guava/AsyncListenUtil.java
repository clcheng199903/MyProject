package com.example.callbackdemo.guava;

import com.google.common.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * 异步线程监听回调工具
 *
 * 应用场景：
 * 1.需要异步线程执行，而且需要获取到线程执行返回的结果
 * 2.如果执行过程异常，可以按照自定义方式消费异常信息
 * （这不是跟CompletableFuture很像吗？）
 */
@Slf4j
public class AsyncListenUtil {
    public static final ExecutorService executorService =
            Executors.newFixedThreadPool(10);

    // 创建一个监听Future的实例线程池
    public static final ListeningExecutorService listeningExecutorService =
            MoreExecutors.listeningDecorator(executorService);

    public static <T> void submit(Callable<T> work, Consumer<T> consumer, Consumer<Throwable> errorConsumer) {
        ListenableFuture<T> listenableFuture = listeningExecutorService.submit(work);
        Futures.addCallback(listenableFuture,
                new FutureCallback<T>() {
                    @Override
                    public void onSuccess(T result) {
                        consumer.accept(result);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        errorConsumer.accept(t);
                    }
                }, listeningExecutorService);
    }

    public static void destory() {
        log.info("摧毁线程池");
        executorService.shutdown();
    }
}

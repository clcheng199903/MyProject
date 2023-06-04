package com.example.callbackdemo.statics;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 调用方
 */
@Slf4j
public class SuperMarket {

    private List<Runnable> runnableList = new ArrayList<>();

    public SuperMarket() {
    }

    public SuperMarket(Runnable runnable) {
        this.runnableList.add(runnable);
    }

    public SuperMarket(Runnable... runnableList) {
        for (Runnable runnable : runnableList) {
            this.runnableList.add(runnable);
        }
    }

    public SuperMarket(List<Runnable> runnableList) {
        this.runnableList = runnableList;
    }

    /**
     * 执行的回调入口
     */
    public void work() {
        log.info("业务代码");
        if (runnableList != null) {
            for (Runnable runnable : runnableList) {
                runnable.run();
            }
        }
    }

    public void work(Runnable runnable) {
        log.info("直接方法调用：业务代码");
        if (runnable != null) {
            runnable.run();
        }
    }


}

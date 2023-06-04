package com.example.callbackdemo.statics;

import lombok.extern.slf4j.Slf4j;

/**
 * 回调类
 */
@Slf4j
public class Person implements Runnable{

    private String name;

    /**
     * 回调函数的参数传入不一定非要从回调的执行方法中传入，完全可以通过此构造函数传参
     */
    public Person(String name) {
        this.name = name;
    }

    @Override
    public void run() {
       log.info("回调函数的业务代码；收到传入值：name-{}", name);
    }
}

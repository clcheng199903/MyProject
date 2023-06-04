package com.example.callbackdemo;

import com.example.callbackdemo.statics.Person;
import com.example.callbackdemo.statics.SuperMarket;
import org.junit.jupiter.api.Test;

public class SuperMarketTest {
    @Test
    public void test() {
        Person ccl = new Person("ccl");
        Person xiaoming = new Person("xiaoming");
        new SuperMarket(ccl, xiaoming).work();

        Person xh = new Person("xh");
        SuperMarket superMarket = new SuperMarket();
        superMarket.work(xh);

    }
}

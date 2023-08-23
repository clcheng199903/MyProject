package com.example.exceptiondemo;

public class ExecptionDemo {
    public static void main(String[] args) {
        new ExecptionDemo().A();
    }

    void A() {
        System.out.println("A1");
        try {
            B();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("A2");
    }

    void B() {
        System.out.println("B1");
        C();
        System.out.println("B2");
    }

    void C() {
        System.out.println("C1");
        throw new RuntimeException("C的运行时异常"); // 遇到异常直接退出程序
//        System.out.println("C2"); // 编译时异常必须抛出，运行时异常可以不抛出
    }
}

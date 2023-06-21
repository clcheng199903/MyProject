package com.example.threadlocaldemo;

public class Main {

    private static ThreadLocal<String> localVar = new ThreadLocal<>();


    public static void main(String[] args) {
        new Thread(() -> {
            localVar.set("A");
            String s = localVar.get();
            System.out.println(s);
        }).start();

        new Thread(() -> {
            localVar.set("B");
            System.out.println(localVar.get());
        }).start();
    }
}

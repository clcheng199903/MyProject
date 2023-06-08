package com.example.typeinfodemo;

/**
 * X.class是class类型，
 */
public class Main {
    public static <T> Class<?> f1(T t, Class<?> cls) {
        System.out.println(t.getClass().getName());
        return cls;
    }

    public static void main(String[] args) {
        Class<?> aClass = f1("123", String.class);
    }
}

package com.demo.beaninit.function;

public class Test {

    public static void main(String[] args) {
        cal(3,4, (a,b) -> {
            return a+b;
        });
    }

    public static void cal(int a, int b, Transimit util) {
        System.out.println(util.transimit(a, b));
    }
}

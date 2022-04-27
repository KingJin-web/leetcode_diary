package com.king.year_2022.M04;

public class Test26 {
    static {
        System.out.println("static1");
    }

    String a = "2";

    static T s = new T();

    static {
        System.out.println("static3");
    }

    public static void main(String[] args) {

    }
}

class T {
    public T() {
        System.out.println("static2");
    }
}
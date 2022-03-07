package com.king.year_2022.M03;

import com.king.util.MyPrint;

import java.math.BigDecimal;

/**
 * @program: leetcode_diary
 * @description: 504. 七进制数
 * @author: King
 * @create: 2022-03-07 22:05
 */
public class Test7 {
    public static void main(String[] args) {
        float a, b;
        double c, d;
        a = (float) 123456.789e5;
        b = a + 20;

        c = 123456.789e5;
        d = c + 20;

        BigDecimal bigDecimal = new BigDecimal("0");

        System.out.print(bigDecimal);
        System.out.printf("%f\n%f\n%f\n%f",a,b,c,d);
    }
}

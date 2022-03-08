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
    public String convertToBase7(int n) {
        boolean flag = n < 0;
        if (flag) n = -n;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(n % 7);
            n /= 7;
        } while (n != 0);
        sb.reverse();
        return flag ? "-" + sb.toString() : sb.toString();
    }

    public String convertToBase72(int num) {
        return Integer.toString(num, 7);
    }

    public static void main(String[] args) {
        Test7 test7 = new Test7();
        MyPrint.print(test7.convertToBase7(123454));

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

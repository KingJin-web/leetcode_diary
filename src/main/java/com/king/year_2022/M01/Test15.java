package com.king.year_2022.M01;

import java.math.BigInteger;

/**
 * @program: leetcode_diary
 * @description:
 * @author: King
 * @create: 2022-01-16 10:02
 */
public class Test15 {
    public static void main(String[] args) {
        BigInteger bigInteger = BigInteger.valueOf(1);
        for (int i = 1;i <= 1000;++i){
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        System.out.println(bigInteger);
        System.out.println(bigInteger.toString().length());
    }
}

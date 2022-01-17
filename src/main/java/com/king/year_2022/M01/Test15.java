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
        //问题一：
        //1000的阶乘末尾有多少个0？
        char []chs = bigInteger.toString().toCharArray();
        for (int i = chs.length -1;i >=0;--i){
            if (chs[i] != '0'){
                System.out.printf("1000的阶乘末尾有%d个0\n",chs.length - i -1);
                break;
            }
        }
        //问题二：
        //1000的阶乘有多少位数？
        System.out.printf("1000的阶乘有%d位数\n",bigInteger.toString().length());
        //问题三：
        //1000的阶乘的值是多少？
        System.out.println("1000的阶乘的值是: " + bigInteger);

         }
}

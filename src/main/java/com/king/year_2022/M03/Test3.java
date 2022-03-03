package com.king.year_2022.M03;

/**
 * @program: leetcode_diary
 * @description: 258. 各位相加
 * https://leetcode-cn.com/problems/add-digits/
 * @author: King
 * @create: 2022-03-03 23:48
 */
public class Test3 {
    //给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。

    public int addDigits1(int num) {
        while (num  >= 10) {
            int sum = 0;
            while ( num != 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}

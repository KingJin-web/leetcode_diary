package com.king.year_2022.M02;

import com.king.util.MyPrint;

/**
 * @program: leetcode_diary
 * @description: 258. 各位相加
 * https://leetcode-cn.com/problems/add-digits/
 * @author: King
 * @create: 2022-02-24 01:00
 */
public class Test24 {
    //给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
    //
    //
    //
    //示例 1:
    //
    //输入: num = 38
    //输出: 2
    //解释: 各位相加的过程为：
    //38 --> 3 + 8 --> 11
    //11 --> 1 + 1 --> 2
    //由于 2 是一位数，所以返回 2。


    public int addDigits1(int num) {
        //除了传统的单纯循环，还可以找规律。假如一个三位数'abc'，其值大小为s1 = 100 * a + 10 * b + 1 * c，
        //经过一次各位相加后，变为s2 = a + b + c，减小的差值为(s1 -s2) = 99 * a + 9 * b，差值可以被9整除，
        //每一个循环都这样，缩小了9的倍数。当num小于9，即只有一位时，直接返回num，大于9时，如果能被9整除，
        //则返回9（因为不可能返回0也不可能返回两位数及以上的值），如果不能被整除，就返回被9除的余数。
        return (num - 1) % 9 + 1;
    }

    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 13.62% 的用户
    public int addDigits(int num) {
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

    public static void main(String[] args) {
        Test24 test24 = new Test24();
        MyPrint.print(test24.addDigits1(38));
        MyPrint.print(test24.addDigits(38));
        MyPrint.print(test24.addDigits(10));
    }
}

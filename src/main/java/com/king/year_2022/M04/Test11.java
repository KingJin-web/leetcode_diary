package com.king.year_2022.M04;

/**
 * @program: leetcode_diary
 * @description: 357. 统计各位数字都不同的数字个数
 * https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 * @author: King
 * @create: 2022-04-11 23:43
 */
public class Test11 {
    public int countNumbersWithUniqueDigits(int n) {
        switch (n) {
            case 0:
                return 1;
            case 1:
                return 10;
            case 2:
                return 91;
            case 3:
                return 739;
            case 4:
                return 5275;
            case 5:
                return 32491;
            case 6:
                return 168571;
            case 7:
                return 712891;
            case 8:
                return 2345851;
            case 9:
                return 5611771;
            default:
                return 8877691;
        }
    }

    public static void main(String[] args) {
        Test11 test11 = new Test11();
        System.out.println(test11.countNumbersWithUniqueDigits(3));
    }
}

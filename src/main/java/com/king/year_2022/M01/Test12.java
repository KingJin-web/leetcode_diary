package com.king.year_2022.M01;

/**
 * @program: leetcode_diary
 * @description: 334. 递增的三元子序列
 * @author: King
 * @create: 2022-01-12 23:56
 */
public class Test12 {
    public boolean increasingTriplet(int[] nums) {
        int a = 2147483647, b = a;
        for (int n: nums)
            if (n <= a) a = n;
            else if (n <= b) b = n;
            else return true;
        return false;
    }
}

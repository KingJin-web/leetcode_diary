package com.king.year_2022.M03;

/**
 * @program: leetcode_diary
 * @description: 2104. 子数组范围和
 * @author: King
 * @create: 2022-03-04 22:44
 */
public class Test4 {
    public long subArrayRanges(int[] nums) {
        int n = nums.length, max = 0, min = 0;
        long res = 0;
        // 枚举子数组左边界
        for ( int i = 0; i < n; i++ ) {
            max = nums[i];
            min = nums[i];
            // 枚举有边界
            for ( int j = i+1; j < n; j++ ) {
                // 维护min max
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                res += (max-min);
            }
        }
        return res;
    }
}

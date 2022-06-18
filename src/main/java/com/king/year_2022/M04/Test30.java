package com.king.year_2022.M04;

/**
 * @author: King
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M04.Test30
 * @date: 2022年04月30日 23:37
 * @description: https://leetcode-cn.com/problems/smallest-range-i/
 * 908. 最小差值 I
 */
public class Test30 {
    //908. 最小差值 I

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 73.51% 的用户 内存消耗： 41.7 MB , 在所有 Java 提交中击败了 66.04% 的用户
     * @param nums
     * @param k
     * @return
     */
    public int smallestRangeI(int[] nums, int k) {
        //获取数组最小值和最大值
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        return Math.max(0, max - min - 2*k);

    }

    public static void main(String[] args) {
        Test30 test30 = new Test30();
        int[] nums = {1,3,6};
        int k = 3;
        System.out.println(test30.smallestRangeI(nums, k));
    }

}
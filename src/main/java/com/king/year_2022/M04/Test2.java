package com.king.year_2022.M04;

/**
 * @program: leetcode_diary
 * @description: 896. 单调数列
 * https://leetcode-cn.com/problems/monotonic-array/
 * @author: King
 * @create: 2022-04-02 02:08
 */
public class Test2 {

    //执行用时： 1 ms , 在所有 Java 提交中击败了 99.14% 的用户 内存消耗： 50.8 MB , 在所有 Java 提交中击败了 95.64% 的用户
    //暴力法
    public boolean isMonotonic(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //那么全部单调递增或者递减
        if (nums[0] == nums[nums.length - 1]) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    return false;
                }
            }
        } else if (nums[0] < nums[nums.length - 1]) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] > nums[i]) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] < nums[i]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        int[] nums = {1, 2, 2, 3};
        System.out.println(test2.isMonotonic(nums));
        int[] nums1 = {1, 1, 2};
        System.out.println(test2.isMonotonic(nums1));
        int[] nums2 = {1, 2, 4, 5};
        System.out.println(test2.isMonotonic(nums2));
        int[] nums3 = {1, 1, 1};
        System.out.println(test2.isMonotonic(nums3));
        int[] nums4 = {1, 1, 5};
        System.out.println(test2.isMonotonic(nums4));

    }
}

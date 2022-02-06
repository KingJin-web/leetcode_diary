package com.king.year_2022.M02;

/**
 * @program: leetcode_diary
 * @description: 1748. 唯一元素的和
 * @author: King
 * @create: 2022-02-06 23:37
 */
public class Test6 {
//    给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
//
//    请你返回 nums 中唯一元素的 和 。
//提示：
//
//1 <= nums.length <= 100
//1 <= nums[i] <= 100

    public int sumOfUnique1(int[] nums) {
        int[] counts = new int[101];
        int sum = 0;
        for (int n : nums) {
            if (counts[n]++ == 0) {
                sum += n;
            } else if (counts[n] == 2) {
                sum -= n;
            }
        }
        return sum;
    }

    public int sumOfUnique(int[] nums) {
        int[] arr = new int[101];
        int sum = 0;
        for (int num : nums) {
            if (++arr[num] == 0) {
                sum += num;
            } else if (++arr[num] == 2) {
                sum -= num;
            }
        }
        return sum;
    }
}

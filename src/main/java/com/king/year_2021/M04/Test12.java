package com.king.year_2021.M04;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 377. 组合总和 Ⅳ
 * 377. 组合总和 Ⅳ
 * @author: King
 * @create: 2021-04-24 15:54
 */
public class Test12 {
    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3, 4},4));
    }
}

class Solution {
    /**
     * 简单递归
     */
    public int combinationSum4_1(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += combinationSum4_1(nums, target - num);
            }
        }
        return res;
    }

    /**
     * 记忆化搜索
     */
    private int[] memo;

    public int combinationSum4_2(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return search(nums, target);
    }

    private int search(int[] nums, int target) {
        if (memo[target] != -1) {
            return memo[target];
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += search(nums, target - num);
            }
        }
        memo[target] = res;
        return res;
    }

    /**
     * 动态规划
     */
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        memo[0] = 1;
        for (int i = 0; i < target; i++) {
            for (int num : nums) {
                if (i + num <= target) {
                    memo[i + num] += memo[i];
                }
            }
        }
        return memo[target];
    }
}
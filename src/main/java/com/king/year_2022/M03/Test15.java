package com.king.year_2022.M03;

/**
 * @program: leetcode_diary
 * @description:
 * @author: King
 * @create: 2022-03-15 22:25
 */
public class Test15 {
    public int countMaxOrSubsets(int[] nums) {
        // 尝试dfs暴力
        // 1.首先对nums所有元素或得到一个最大值
        int max = 0;
        for (int num : nums) {
            max |= num;
        }
        // 2.dfs所有情况, 可选或可不选
        return dfs(0, nums, 0, max);
    }

    private int dfs(int curIndex, int[] nums, int curValue, int max) {
        if (curIndex == nums.length) {
            return curValue == max ? 1 : 0;
        }
        return dfs(curIndex + 1, nums, curValue | nums[curIndex], max) + dfs(curIndex + 1, nums, curValue, max);
    }
}

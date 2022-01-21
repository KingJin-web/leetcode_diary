package com.king.year_2022.M01;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode_diary
 * @description: 219. 存在重复元素 II
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 * @author: King
 * @create: 2022-01-19 21:53
 */
public class Test19 {

    //给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j]
    // 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
    public static void main(String[] args) {
        Test19 test19 = new Test19();
        MyPrint.print(test19.containsNearbyDuplicate1(
                LeetcodeUtil.stringToIntegerArray("[1,2,3,1]"),3));
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

//
//
//示例 1：
//
//输入：nums = [1,2,3,1], k = 3
//输出：true
//示例 2：
//
//输入：nums = [1,0,1,1], k = 1
//输出：true
//示例 3：
//
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false


}

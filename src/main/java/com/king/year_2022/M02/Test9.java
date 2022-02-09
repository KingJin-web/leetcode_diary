package com.king.year_2022.M02;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode_diary
 * @description: 2006. 差的绝对值为 K 的数对数目
 * @author: King
 * @create: 2022-02-09 23:38
 */
public class Test9 {

    /**
     * 使用哈希
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 75.04% 的用户
     * 内存消耗： 40.7 MB ,所有 Java 提交中击败了 10.39% 的用户
     * @param nums
     * @param k
     * @return
     */
    public int countKDifference1(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            if (seen.containsKey(num + k)) {
                ans += seen.get(num + k);
            }
            if (seen.containsKey(num - k)) {
                ans += seen.get(num - k);
            }
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }
        return ans;
    }

    /**
     * 暴力法
     * 执行用时： 8 ms , 在所有 Java 提交中击败了 14.29% 的用户
     * 内存消耗： 40.9 MB , 在所有 Java 提交中击败了 7.50% 的用户
     * @param nums
     * @param k
     * @return
     */
    public Object countKDifference(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0;i < n;++i){
            for (int j = i + 1;j < n;++j){
                if (Math.abs(nums[i] - nums[j])== k){
                    ++count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Test9 test9 = new Test9();
//输入：nums = [1,2,2,1], k = 1
//输出：4
//解释：差的绝对值为 1 的数对为：
//- [1,2,2,1]
//- [1,2,2,1]
//- [1,2,2,1]
//- [1,2,2,1]
        MyPrint.printObs(test9.countKDifference1(LeetcodeUtil.stringToIntegerArray("[1,2,2,1]"),1),
                test9.countKDifference(LeetcodeUtil.stringToIntegerArray("[1,2,2,1]"),1)
                );

    }


}
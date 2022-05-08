package com.king.year_2022.M05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: 12613
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M05.Test8
 * @date: 2022年05月08日 23:51
 * @description: ${}
 */
public class Test8 {
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[(nums[i] - 1) % n] += n;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n) ret.add(i + 1);
        }
        return ret;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                ret.add(num);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Test8 test8 = new Test8();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(test8.findDuplicates(nums));
        System.out.println(test8.findDuplicates1(nums));
    }
}
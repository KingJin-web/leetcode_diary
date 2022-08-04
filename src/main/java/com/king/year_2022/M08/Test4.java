package com.king.year_2022.M08;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年08月04日 23:43
 * @description: 1403. 非递增顺序的最小子序列
 */
public class Test4 {
    public List<Integer> minSubsequence(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        Arrays.sort(nums);
        sum[0] = nums[0];
        for(int i = 1; i < n; i++){
            sum[i] = sum[i - 1] + nums[i];
        }
        List<Integer> ans = new LinkedList<>();
        int candidate = n - 1;
        int candidateSum = 0;
        while(candidate >= 0 && candidateSum <= sum[candidate]){
            ans.add(nums[candidate]);
            candidateSum += nums[candidate];
            candidate--;
        }
        return ans;
    }
}
package com.king.year_2022.M07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月04日 23:53
 * @description: 1200. 最小绝对差
 */
public class Test4 {
    //给你个整数数组 arr，其中每个元素都 不相同。
    //
    //请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        int best = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < n - 1; ++i) {
            int delta = arr[i + 1] - arr[i];
            if (delta < best) {
                best = delta;
                ans.clear();
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                ans.add(pair);
            } else if (delta == best) {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                ans.add(pair);
            }
        }

        return ans;
    }
}
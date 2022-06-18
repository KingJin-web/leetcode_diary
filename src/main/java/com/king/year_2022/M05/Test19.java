package com.king.year_2022.M05;

import com.king.util.Helper;
import com.king.util.MyPrint;
import com.king.util.StringUtil;

import java.util.Arrays;

/**
 * @author: King
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M05.Test19
 * @date: 2022年05月19日 23:51
 * @description: 462. 最少移动次数使数组元素相等 II
 */
public class Test19 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0,j = nums.length - 1, res = 0;
        while (i < j) {
            res += nums[j--] - nums[i++];
        }
        return res;
    }

    public static void main(String[] args) {
        Test19 test19 = new Test19();
        int[] nums= Helper.getArrays(1,2,3);
        MyPrint.print(nums);
        MyPrint.print(test19.minMoves2(nums));

    }


}
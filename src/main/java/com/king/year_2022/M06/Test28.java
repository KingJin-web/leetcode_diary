package com.king.year_2022.M06;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年06月28日 23:22
 * @description: 324. 摆动排序 II
 */
public class Test28 {
    public int[] wiggleSort1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && (i % 2 == 0 && nums[i] > nums[i + 1] || i % 2 == 1 && nums[i] < nums[i + 1])) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Test28 test28 = new Test28();
        MyPrint.print(test28.wiggleSort(LeetcodeUtil.stringToIntegerArray("[1,5,1,1,6,4]")));
    }

    public int[] wiggleSort2(int[] nums) {
        int[] result = new int[nums.length];
        System.arraycopy(nums, 0, result, 0, result.length);
        Arrays.sort(result);
        int j = nums.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = result[j--];
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = result[j--];
        }

        return result;
    }

    public int[] wiggleSort(int[] nums) {
        int[] result = nums.clone();
        Arrays.sort(result);
        int j = nums.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = result[j--];
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = result[j--];
        }
        return nums;

    }
}
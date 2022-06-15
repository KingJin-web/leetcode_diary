package com.king.year_2022.M06;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @author: 12613
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M06.Test15
 * @date: 2022年06月15日 21:33
 * @description: ${}
 */
public class Test15 {

        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
            while (left <= right) {
                int mid = (left + right) / 2;
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    int i = binarySearch(nums, j, nums[j] - mid);
                    cnt += j - i;
                }
                if (cnt >= k) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        public int binarySearch(int[] nums, int end, int target) {
            int left = 0, right = end;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

    public static void main(String[] args) {
        Test15 test15 = new Test15();
        MyPrint.print(test15.smallestDistancePair(LeetcodeUtil.stringToIntegerArray("[1,3,1]"),1));
    }
}
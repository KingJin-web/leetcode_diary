package com.king.year_2022.M07;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月17日 23:30
 * @description: 565. 数组嵌套
 */
public class Test17 {
    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                continue;
            }
            int count = 0;
            int index = i;
            while (nums[index] != -1) {
                int temp = index;
                index = nums[index];
                nums[temp] = -1;
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        Test17 test17 = new Test17();
        int[] nums = {5,4,0,3,1,6,2};
        System.out.println(test17.arrayNesting(nums));
    }
}
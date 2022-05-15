package com.king.year_2022.M05;

import java.util.Random;

/**
 * @author: 12613
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M05.Test13
 * @date: 2022年05月13日 02:45
 * @description: 13. 罗马数字转整数
 */
public class Test13 {

    //沙雕代码：随机查找
    public int randomSearch(int [] nums, int n) {
        Random random = new Random();
        for (;;) {
            int index = random.nextInt(n);
            if (nums[index] == n) {
                return index;
            }
        }
    }

    public static void main(String[] args) {
        Test13 test13 = new Test13();
        int [] nums = {1,2,3,4,5,6,7,8,9,10};
        int n = 10;
        System.out.println(test13.randomSearch(nums, n));
    }

}
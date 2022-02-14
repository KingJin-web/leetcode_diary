package com.king.year_2022.M02;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

/**
 * @program: leetcode_diary
 * @description: 540. 有序数组中的单一元素
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 * @author: King
 * @create: 2022-02-14 23:24
 */
public class Test14 {
    //给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
    //
    //请你找出并返回只出现一次的那个数。
    //
    //你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。

    //执行用时： 1 ms , 在所有 Java 提交中击败了 22.98% 的用户 内存消耗： 46.9 MB , 在所有 Java 提交中击败了 13.52% 的用户
    public int singleNonDuplicate(int[] nums) {
        int num = 0;
        for(int i : nums)
            num ^= i;

        return num;
    }

    public static void main(String[] args) {
        Test14 test14 = new Test14();
        MyPrint.printObs(test14.singleNonDuplicate(LeetcodeUtil.stringToIntegerArray("[3,3,7,7,10,11,11]")));
    }
}

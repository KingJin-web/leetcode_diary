package com.king.year_2022.M02;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

/**
 * @program: leetcode_diary
 * @description: 540. 有序数组中的单一元素
 * @author: King
 * @create: 2022-02-14 23:24
 */
public class Test14 {

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

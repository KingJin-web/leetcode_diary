package com.king.year_2022.M04;

/**
 * @program: leetcode_diary
 * @description: 744. 寻找比目标字母大的最小字母
 * @author: King
 * @create: 2022-04-03 23:39
 */
public class Test3 {
    //给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
    //
    //在比较时，字母是依序循环出现的。举个例子：
    //
    //如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
    //
    //
    //示例 1：
    //
    //输入: letters = ["c", "f", "j"]，target = "a"
    //输出: "c"
    //示例 2:
    //
    //输入: letters = ["c","f","j"], target = "c"
    //输出: "f"
    //示例 3:
    //
    //输入: letters = ["c","f","j"], target = "d"
    //输出: "f"

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return letters[left % letters.length];
    }

}

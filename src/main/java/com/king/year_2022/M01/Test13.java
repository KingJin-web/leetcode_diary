package com.king.year_2022.M01;

import com.king.util.ArraysUtil;
import com.king.util.Helper;
import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: leetcode_diary
 * @description: 747. 至少是其他数字两倍的最大数
 * https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
 * @author: King
 * @create: 2022-01-13 21:24
 */
public class Test13 {
    //给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
    //请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。


    //执行用时： 4 ms , 在所有 Java 提交中击败了 11.53% 的用户 内存消耗： 36.4 MB , 在所有 Java 提交中击败了 8.85% 的用户
    public int dominantIndex(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Arrays.sort(nums);

        int max1 = nums[n - 1];
        int max2 = nums[n - 2];
        return max1 >= max2 * 2 ? list.indexOf(max1) : -1;

    }


    public static void main(String[] args) {
        Test13 o = Helper.getYoursObj(Test13.class);
        MyPrint.print(o.dominantIndex(LeetcodeUtil.stringToIntegerArray("[3,6,1,0]")));
        MyPrint.print(o.reverseWords("I am a student. "));
    }

    //剑指 Offer 58 - I. 翻转单词顺序
    //https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
    //输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
    // 例如输入字符串""，则输出"student. a am I"。
    public String reverseWords(String s) {
//        String s = "I am a student";
        String[] arr = s.trim().split(" ");
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - 1 - i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; ++i) {
            sb.append(arr[i]).append(" ");
        }
        sb.append(arr[n - 1]);
        return sb.toString();
    }

    public String reverseWords1(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while (i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }


}

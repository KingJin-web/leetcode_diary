package com.king.year_2022.M01;

import com.king.util.Helper;
import com.king.util.MyPrint;

/**
 * @program: leetcode_diary
 * @description:
 * @author: King
 * @create: 2022-01-13 21:24
 */
public class Test13 {

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
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }

    public static void main(String[] args) {
        Test13 o = Helper.getYoursObj(Test13.class);
        MyPrint.print(o.reverseWords("I am a student. "));
    }
}

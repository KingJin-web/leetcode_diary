package com.king.year_2022.M02;

import com.king.util.MyPrint;

/**
 * @program: leetcode_diary
 * @description: 2000. 反转单词前缀
 * https://leetcode-cn.com/problems/reverse-prefix-of-word/submissions/
 * @author: King
 * @create: 2022-02-02 23:19
 */
public class Test2 {
    //给你一个下标从 0 开始的字符串 word 和一个字符 ch 。找出 ch 第一次出现的下标 i ，
    // 反转 word 中从下标 0 开始、直到下标 i 结束（含下标 i ）的那段字符。如果 word 中不存在字符 ch ，则无需进行任何操作。
    //
    //例如，如果 word = "abcdefd" 且 ch = "d" ，那么你应该 反转 从下标 0 开始、直到下标 3 结束（含下标 3 ）。
    // 结果字符串将会是 "dcbaefd" 。
    //返回 结果字符串 。


    //方法一 ： 调api
    //执行用时： 1 ms , 在所有 Java 提交中击败了 27.67% 的用户 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 5.16% 的用户
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index < 0) {
            return word;
        }
        StringBuilder sb = new StringBuilder(word.substring(0, index + 1));
        return word.replace(sb.toString(), sb.reverse().toString());

    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        MyPrint.printObs(test2.reversePrefix("abcdefd", 'd'));
    }
}

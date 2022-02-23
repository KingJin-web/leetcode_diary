package com.king.year_2022.M02;

import com.king.util.MyPrint;

/**
 * @program: leetcode_diary
 * @description: 917. 仅仅反转字母
 * https://leetcode-cn.com/problems/reverse-only-letters/
 * @author: King
 * @create: 2022-02-23 20:31
 */
public class Test23 {

    //给你一个字符串 s ，根据下述规则反转字符串：
    //
    //所有非英文字母保留在原有位置。
    //所有英文字母（小写或大写）位置反转。
    //返回反转后的 s 。

    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 39.4 MB , 在所有 Java 提交中击败了 12.35% 的用户
    public String reverseOnlyLetters(String s) {
        char[] chs = s.toCharArray();
        int i = 0, n = s.length();
        while (i < n) {
            if (isCase(chs[i]) && isCase(chs[n -1] )){
                char c = chs[n - 1];
                chs[n -1] = chs[i];
                chs[i] = c;
                --n;
                ++i;
            }else if (!isCase(chs[i]) ){
                ++i;
            }else if (!isCase(chs[n-1])){
                --n;
            }
        }
        return new String(chs);
    }

    private boolean isCase(char c) {
        return Character.isLowerCase(c) || Character.isUpperCase(c);
    }

    public static void main(String[] args) {
        //输入：s = "ab-cd"
        //输出："dc-ba"
        Test23 test23 = new Test23();
        MyPrint.print(test23.reverseOnlyLetters("ab-cd"));
    }
}

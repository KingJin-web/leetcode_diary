package com.king.year_2022.M02;

/**
 * @program: leetcode_diary
 * @description: 1763. 最长的美好子字符串
 * @author: King
 * @create: 2022-02-01 23:15
 */
public class Test1 {
    //当一个字符串 s 包含的每一种字母的大写和小写形式 同时 出现在 s 中，就称这个字符串 s 是 美好 字符串。比方说，"abABB" 是美好字符串，
    // 因为 'A' 和 'a' 同时出现了，且 'B' 和 'b' 也同时出现了。然而，"abA" 不是美好字符串因为 'b' 出现了，而 'B' 没有出现。
    //
    //给你一个字符串 s ，请你返回 s 最长的 美好子字符串 。如果有多个答案，请你返回 最早 出现的一个。如果不存在美好子字符串，
    // 请你返回一个空字符串。


        public String longestNiceSubstring(String s) {
            int n = s.length();
            int maxPos = 0;
            int maxLen = 0;
            for (int i = 0; i < n; ++i) {
                int lower = 0;
                int upper = 0;
                for (int j = i; j < n; ++j) {
                    if (Character.isLowerCase(s.charAt(j))) {
                        lower |= 1 << (s.charAt(j) - 'a');
                    } else {
                        upper |= 1 << (s.charAt(j) - 'A');
                    }
                    if (lower == upper && j - i + 1 > maxLen) {
                        maxPos = i;
                        maxLen = j - i + 1;
                    }
                }
            }
            return s.substring(maxPos, maxPos + maxLen);
        }


}

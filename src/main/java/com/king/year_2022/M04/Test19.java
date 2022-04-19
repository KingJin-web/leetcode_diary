package com.king.year_2022.M04;

import java.util.Arrays;

/**
 * @program: leetcode_diary
 * @description: 821. 字符的最短距离
 * @author: King
 * @create: 2022-04-19 23:30
 */
public class Test19 {
    public int[] shortestToChar(String s, char c) {
        char[] ch = s.toCharArray();
        int[] ans = new int[ch.length];
        Arrays.fill(ans, ch.length + 5);
        for (int i = 0; i < ch.length; i++) {
            int j = i;
            while (j >= 0 && ch[j] != c) {
                j--;
            }
            if (j >= 0) {
                ans[i] = i - j;
            }
            j = i;
            while (j < ch.length && ch[j] != c) {
                j++;
            }
            if (j < ch.length) {
                ans[i] = Math.min(ans[i], j - i);
            }
        }
        return ans;
    }
}

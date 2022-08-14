package com.king.year_2022.M08;

import com.king.util.MyPrint;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年08月14日 23:42
 * @description: 1422. 分割字符串的最大得分
 */
public class Test14 {
    public int maxScore(String s) {
        int n = s.length(), ans = 0;
        int[] sum = new int[n + 10];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + (s.charAt(i - 1) - '0');
        for (int i = 1; i <= n - 1; i++) {
            int a = i - sum[i], b = sum[n] - sum[i];
            ans = Math.max(ans, a + b);
        }
        return ans;
    }

    public static void main(String[] args) {
        Test14 test14 = new Test14();
        MyPrint.print(test14.maxScore("011101"));
    }
}
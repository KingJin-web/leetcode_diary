package com.king.year_2022.M06;

import com.king.util.MyPrint;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年06月27日 23:14
 * @description: 522. 最长特殊序列 II
 */
public class Test27 {
    //522. 最长特殊序列 II
   private static class Solution {
        public int findLUSlength(String[] strs) {
            int n = strs.length;
            int ans = -1;
            for (int i = 0; i < n; ++i) {
                boolean check = true;
                for (int j = 0; j < n; ++j) {
                    if (i != j && isSubseq(strs[i], strs[j])) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    ans = Math.max(ans, strs[i].length());
                }
            }
            return ans;
        }

        public boolean isSubseq(String s, String t) {
            int ptS = 0, ptT = 0;
            while (ptS < s.length() && ptT < t.length()) {
                if (s.charAt(ptS) == t.charAt(ptT)) {
                    ++ptS;
                }
                ++ptT;
            }
            return ptS == s.length();
        }
    }


    public int findLenth(String[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    if (A[i].charAt(j) == A[i].charAt(j - 1)) {
                        dp[i][j] = dp[i][j] + 1;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i][n - 1]);
        }
        return max;
    }

    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (strs[i].equals(strs[j])) {
                    continue;
                }
                if (isSubsequence(strs[i], strs[j])) {
                    continue;
                }
                max = Math.max(max, Math.max(strs[i].length(), strs[j].length()));
            }
        }
        return max;

    }

    private boolean isSubsequence(String str, String str1) {
        int m = str.length();
        int n = str1.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (str.charAt(i) == str1.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }

    public static void main(String[] args) {
        Test27 test27 = new Test27();
        //输入: strs = ["aba","cdc","eae"]
        //输出: 3
        //解释: 最长特殊序列可能为 "aba" (或 "cdc" 或 "eae")。
        String[] strs = {"aba", "cdc", "eae"};
        MyPrint.println(test27.findLUSlength(strs));
        Solution solution = new Solution();
        MyPrint.println(solution.findLUSlength(strs));

    }
}
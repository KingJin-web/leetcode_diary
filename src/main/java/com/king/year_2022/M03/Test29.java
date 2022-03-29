package com.king.year_2022.M03;

/**
 * @program: leetcode_diary
 * @description: 2024. 考试的最大困扰度
 * @author: King
 * @create: 2022-03-29 23:41
 */
public class Test29 {
    //一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。
    //
    //给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
    //
    //每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
    //请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
    public int maxConsecutiveAnswers(String answerKey, int k) {
        /* dp[i][j][ch] 表示 [0, i] 范围内, 使用不超过j次操作后,
                        以 ch(01分别代表FT) 结尾的最大后缀长度
           dp[i] 只由 dp[i-1] 转移而来，可用滚动数组优化空间
         */
        int n = answerKey.length(), ans = 0;
        int[][] f = new int[k + 1][2];// dp[i-1]
        for (int i = 0; i < n; ++i) {
            int[][] g = new int[k + 1][2];// dp[i]
            if (answerKey.charAt(i) == 'T') {// 结尾为T
                for (int j = 0; j <= k; ++j) {
                    // 使用1次操作把T变成F，与左边的F连接起来
                    // 当前用了1次，左边就剩余j - 1次操作机会
                    if (j > 0) g[j][0] = f[j - 1][0] + 1;
                    // 不使用操作，直接与左边的T连接起来
                    g[j][1] = f[j][1] + 1;
                }
            } else {// 结尾为F，与上面同理
                for (int j = 0; j <= k; ++j) {
                    g[j][0] = f[j][0] + 1;
                    if (j > 0) g[j][1] = f[j - 1][1] + 1;
                }
            }
            ans = Math.max(ans, g[k][0]);
            ans = Math.max(ans, g[k][1]);
            f = g;
        }
        return ans;
    }

    class Solution {
        public int maxConsecutiveAnswers(String answerKey, int k) {
            return Math.max(maxConsecutiveChar(answerKey, k, 'T'), maxConsecutiveChar(answerKey, k, 'F'));
        }

        public int maxConsecutiveChar(String answerKey, int k, char ch) {
            int n = answerKey.length();
            int ans = 0;
            for (int left = 0, right = 0, sum = 0; right < n; right++) {
                sum += answerKey.charAt(right) != ch ? 1 : 0;
                while (sum > k) {
                    sum -= answerKey.charAt(left++) != ch ? 1 : 0;
                }
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }
    public static void main(String[] args) {

    }
}

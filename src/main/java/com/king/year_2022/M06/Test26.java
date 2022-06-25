package com.king.year_2022.M06;

import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年06月25日 22:51
 * @description: 剑指 Offer II 091. 粉刷房子
 */
public class Test26 {

    private static class Solution {
        public int minCost(int[][] costs) {
            int n = costs.length;
            int[] dp = new int[3];
            for (int j = 0; j < 3; j++) {
                dp[j] = costs[0][j];
            }
            for (int i = 1; i < n; i++) {
                int[] dpNew = new int[3];
                for (int j = 0; j < 3; j++) {
                    dpNew[j] = Math.min(dp[(j + 1) % 3], dp[(j + 2) % 3]) + costs[i][j];
                }
                dp = dpNew;
            }
            return Arrays.stream(dp).min().getAsInt();
        }
    }


    public static void main(String[] args) {
        int[][] costs = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        MyPrint.println(new Solution().minCost(costs));

        //输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
        //输出: 10
        //解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
        //     最少花费: 2 + 5 + 3 = 10。
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode.cn/problems/JEj789
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        int[][] costs2 = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        MyPrint.println(new Solution().minCost(costs2));
    }
}
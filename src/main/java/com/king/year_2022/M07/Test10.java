package com.king.year_2022.M07;

import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月10日 23:40
 * @description: https://leetcode.cn/problems/cherry-pickup/
 */
public class Test10 {
  private static   class Solution {
        public int cherryPickup(int[][] grid) {
            int n = grid.length;
            int[][][] f = new int[n * 2 - 1][n][n];
            for (int i = 0; i < n * 2 - 1; ++i) {
                for (int j = 0; j < n; ++j) {
                    Arrays.fill(f[i][j], Integer.MIN_VALUE);
                }
            }
            f[0][0][0] = grid[0][0];
            for (int k = 1; k < n * 2 - 1; ++k) {
                for (int x1 = Math.max(k - n + 1, 0); x1 <= Math.min(k, n - 1); ++x1) {
                    int y1 = k - x1;
                    if (grid[x1][y1] == -1) {
                        continue;
                    }
                    for (int x2 = x1; x2 <= Math.min(k, n - 1); ++x2) {
                        int y2 = k - x2;
                        if (grid[x2][y2] == -1) {
                            continue;
                        }
                        int res = f[k - 1][x1][x2]; // 都往右
                        if (x1 > 0) {
                            res = Math.max(res, f[k - 1][x1 - 1][x2]); // 往下，往右
                        }
                        if (x2 > 0) {
                            res = Math.max(res, f[k - 1][x1][x2 - 1]); // 往右，往下
                        }
                        if (x1 > 0 && x2 > 0) {
                            res = Math.max(res, f[k - 1][x1 - 1][x2 - 1]); // 都往下
                        }
                        res += grid[x1][y1];
                        if (x2 != x1) { // 避免重复摘同一个樱桃
                            res += grid[x2][y2];
                        }
                        f[k][x1][x2] = res;
                    }
                }
            }
            return Math.max(f[n * 2 - 2][n - 1][n - 1], 0);
        }
    }

    public static void main(String[] args) {
      Solution s = new Solution();
      //输入: grid =
        //[[0, 1, -1],
        // [1, 0, -1],
        // [1, 1,  1]]
        //输出: 5
        int[][] grid = {{0, 1, -1},
                        {1, 0, -1},
                        {1, 1,  1}};
        MyPrint.println(s.cherryPickup(grid));

    }
}
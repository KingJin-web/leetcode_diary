package com.king.year_2022.M02;

import com.king.util.MyPrint;

/**
 * @program: leetcode_diary
 * @description: 688. 骑士在棋盘上的概率
 * https://leetcode-cn.com/problems/knight-probability-in-chessboard/
 * @author: King
 * @create: 2022-02-17 23:10
 */
public class Test17 {


    static int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (step == 0) {
                        dp[step][i][j] = 1;
                    } else {
                        for (int[] dir : dirs) {
                            int ni = i + dir[0], nj = j + dir[1];
                            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                                dp[step][i][j] += dp[step - 1][ni][nj] / 8;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }

    public static void main(String[] args) {
        Test17 test17 = new Test17();
        MyPrint.print(test17.knightProbability(3, 2, 0, 0));
    }
}

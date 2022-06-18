package com.king.year_2022.M06;

/**
 * @author: King
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M06.Test14
 * @date: 2022年06月14日 23:24
 * @description: 498. 对角线遍历
 */
public class Test14 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int r = 0, c = 0;
        int row = matrix.length, col = matrix[0].length;
        int[] res = new int[row * col];
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[r][c];
            // r + c 即为遍历的层数，偶数向上遍历，奇数向下遍历
            if ((r + c) % 2 == 0) {
                if (c == col - 1) {
                    // 往下移动一格准备向下遍历
                    r++;
                } else if (r == 0) {
                    // 往右移动一格准备向下遍历
                    c++;
                } else {
                    // 往上移动
                    r--;
                    c++;
                }
            } else {
                if (r == row - 1) {
                    // 往右移动一格准备向上遍历
                    c++;
                } else if (c == 0) {
                    // 往下移动一格准备向上遍历
                    r++;
                } else {
                    // 往下移动
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}
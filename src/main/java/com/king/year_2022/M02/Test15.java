package com.king.year_2022.M02;

import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode_diary
 * @description: 1380. 矩阵中的幸运数
 * @author: King
 * @create: 2022-02-15 22:41
 */
public class Test15 {

    //给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
    //
    //幸运数是指矩阵中满足同时下列两个条件的元素：
    //
    //在同一行的所有元素中最小
    //在同一列的所有元素中最大

    int N = 55;
    int[] row = new int[N], col = new int[N];
    public List<Integer> luckyNumbers1 (int[][] mat) {
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++) {
            row[i] = 100001;
            for (int j = 0; j < m; j++) {
                row[i] = Math.min(row[i], mat[i][j]);
                col[j] = Math.max(col[j], mat[i][j]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int t = mat[i][j];
                if (t == row[i] && t == col[j]) ans.add(t);
            }
        }
        return ans;
    }
    public List<Integer> luckyNumbers (int[][] matrix) {

        int x[] = new int[matrix.length];
        int y[] = new int[matrix[0].length];
        for (int i = 0;i < matrix.length;++i){
            MyPrint.print(matrix[i]);
        }
        return null;
    }

    //输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
    //输出：[15]
    //解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。

    static int [][]matrixs = {{3,7,8},{9,11,13},{15,16,17}};
    public static void main(String[] args) {

        Test15 test15 = new Test15();
        MyPrint.print(test15.luckyNumbers(matrixs));
    }
}

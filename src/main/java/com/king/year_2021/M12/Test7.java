package com.king.year_2021.M12;

import com.king.util.Helper;
import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 1034. �߽���ɫ
 * https://leetcode-cn.com/problems/coloring-a-border/
 * @author: King
 * @create: 2021-12-07 18:57
 */
public class Test7 {

    public void dfs(int[][] grid, int x, int y, int pre, int color, int[][] mask) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != pre) {
            return;
        }
        grid[x][y] = color;
        mask[x][y] = 1;
        dfs(grid, x - 1, y, pre, color, mask);
        dfs(grid, x + 1, y, pre, color, mask);
        dfs(grid, x, y - 1, pre, color, mask);
        dfs(grid, x, y + 1, pre, color, mask);
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        if (grid[row][col] == color) {
            return grid;
        }
        int pre = grid[row][col];
        int[][] mask = new int[grid.length][grid[0].length];
        dfs(grid, row, col, pre, color, mask);
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (mask[i][j] == 1 && mask[i - 1][j] == 1 && mask[i + 1][j] == 1 && mask[i][j - 1] == 1 && mask[i][j + 1] == 1) {
                    grid[i][j] = pre;
                }
            }
        }
        return grid;
    }


    public int MAX(int a, int b) {
        return a > b ? a : b;
    }


    public void deleteList(List<Integer> list) {

        double sum = 0;
        for (int num : list) {
            sum += num;
        }
        double avg = sum / list.size();
        List<Integer> temp = new ArrayList<>();
        for (int num : list) {
            if (num < avg) {
                temp.add(num);
            }
        }

        list.removeAll(temp);
    }


    public static void main(String[] args) {
        //���룺grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
        //�����[[1,3,3],[2,3,3]]
        int arr[][] = {{1, 2, 2}, {2, 3, 2}};
        Test7 test7 = new Test7();
        List<Integer> list = new ArrayList<>();
        list.addAll(Helper.getList(1,2,3,4,5,6));
        test7.deleteList(list);
        MyPrint.print(list);

        MyPrint.print(test7.colorBorder(arr, 0, 1, 3));


        int a = 2, b = 3;
        int c = Math.max(a, b);
        System.out.println(c);
        c = test7.MAX(a, b);
        System.out.println(c);
    }

}

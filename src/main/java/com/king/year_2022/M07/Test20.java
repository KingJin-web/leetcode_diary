package com.king.year_2022.M07;

import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月20日 23:17
 * @description: 1260. 二维网格迁移
 */
public class Test20 {
    public int[][] shiftGrid1(int[][] grid, int k) {
        int[][] result = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result[i][j] = grid[i][(j + k) % grid[0].length];
            }
        }
        return result;
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[] nums = new int[grid.length * grid[0].length];
        for (int[] ints : grid) {
            for (int j = 0, jMax = grid[0].length; j < jMax; j++) {
                k %= nums.length;
                nums[k++] = ints[j];
            }
        }
        k = 0;
        List<List<Integer>> lists = new ArrayList<>(grid.length);
        for(int i = 0, iMax = grid.length;i < iMax;i++) {
            List<Integer> tempList = new ArrayList<>(grid[0].length);
            for(int j = 0, jMax = grid[0].length;j < jMax;j++) {
                tempList.add(nums[k++]);
            }
            lists.add(tempList);
        }
        return lists;
    }

    public static void main(String[] args) {
        Test20 test20 = new Test20();
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        MyPrint.print(test20.shiftGrid1(grid, 1));
        MyPrint.print(test20.shiftGrid(grid, 1));
    }
}
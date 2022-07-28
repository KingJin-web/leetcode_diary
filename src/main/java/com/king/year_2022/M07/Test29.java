package com.king.year_2022.M07;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月29日 04:11
 * @description: 593. 有效的正方形
 * <a href="https://leetcode.cn/problems/valid-square/">...</a>
 */
public class Test29 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //任选三个点 都是 一个直角三角形
        return isRightTriangle(p1, p2, p3) && isRightTriangle(p1, p2, p4) && isRightTriangle(p1, p3, p4) && isRightTriangle(p2, p3, p4);
    }

    public boolean isRightTriangle(int[] p1, int[] p2, int[] p3) {
        int d1 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        int d2 = (p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) * (p2[1] - p3[1]);
        int d3 = (p3[0] - p1[0]) * (p3[0] - p1[0]) + (p3[1] - p1[1]) * (p3[1] - p1[1]);
        return d1 > d2 && d2 == d3 && d2 + d3 == d1 ||
                d2 > d1 && d1 == d3 && d1 + d3 == d2 ||
                d3 > d1 && d1 == d2 && d1 + d2 == d3;
    }

    public static void main(String[] args) {
        Test29 test29 = new Test29();
        int[] p1 = {0, 0};
        int[] p2 = {1, 1};
        int[] p3 = {1, 0};
        int[] p4 = {0, 1};
        System.out.println(test29.validSquare(p1, p2, p3, p4));
    }
}
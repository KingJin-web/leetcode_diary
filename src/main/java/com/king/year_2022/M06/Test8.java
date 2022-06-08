package com.king.year_2022.M06;

/**
 * @author: 12613
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M06.Test8
 * @date: 2022年06月08日 23:24
 * @description: 1037. 有效的回旋镖
 */

public class Test8 {
    public boolean isBoomerang(int[][] p) {
        return (p[0][0] * (p[1][1] - p[2][1]) + p[1][0] * (p[2][1] - p[0][1]) + p[2][0] * (p[0][1] - p[1][1])) != 0;
    }
}
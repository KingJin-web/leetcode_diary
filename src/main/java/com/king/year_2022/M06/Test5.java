package com.king.year_2022.M06;

import java.util.Random;

/**
 * @author: 12613
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M06.Test5
 * @date: 2022年06月05日 22:51
 * @description: ${}
 */
public class Test5 {
    private static class Solution {

        Random random = new Random();
        double radius;
        double x_center;
        double y_center;

        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x_center = x_center;
            this.y_center = y_center;
        }

        public double[] randPoint() {
            while (true) {
                double randomX = random.nextDouble() * (radius * 2) - radius;
                double randomY = random.nextDouble() * (radius * 2) - radius;
                if (randomX * randomX + randomY * randomY <= radius * radius)
                    return new double[]{randomX + x_center, randomY + y_center};
            }
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
}
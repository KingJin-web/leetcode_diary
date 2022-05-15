package com.king.year_2022.M05;

/**
 * @author: 12613
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M05.Test15
 * @date: 2022年05月15日 23:29
 * @description: 812. 最大三角形面积
 */
public class Test15 {
//    public int largestTriangleArea(int[][] points) {
//        int max = 0;
//        for (int i = 0; i < points.length; i++) {
//            for (int j = i + 1; j < points.length; j++) {
//                for (int k = j + 1; k < points.length; k++) {
//                    max = Math.max(max, area(points[i], points[j], points[k]));
//                }
//            }
//        }
//        return max;
//    }
//
//    private int area(int[] p1, int[] p2, int[] p3) {
//        return Math.abs((p1[0] - p3[0]) * (p2[1] - p3[1]) - (p2[0] - p3[0]) * (p1[1] - p3[1])) / 2;
//    }

    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double res = 0;
        for (int i = 0 ; i < n - 2 ; i++){
            int a[] = points[i];
            for (int j = i + 1; j < n - 1 ; j++){
                int b[] = points[j];
                for (int k = j + 1 ; k < n ; k++){
                    int c[] = points[k];
                    int xAB = b[0] - a[0];
                    int yAB = b[1] - a[1];
                    int xAC = c[0] - a[0];
                    int yAC = c[1] - a[1];
                    double v = Math.abs(xAB * yAC - xAC * yAB) / 2.0;
                    if (v > res)
                        res = v;

                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Test15 test15 = new Test15();
        int[][] points = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        System.out.println(test15.largestTriangleArea(points));

    }
}
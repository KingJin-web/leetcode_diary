package com.king.year_2022.M07;

import com.king.util.MyPrint;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月25日 02:04
 * @description: 1184. 公交站间的距离
 */
public class Test24 {
    public int distanceBetweenBusStops1(int[] distance, int start, int destination) {
        int d1 = 0, d2 = 0;
        int l = Math.min(start, destination);
        int r = Math.max(start, destination);
        for (int i = 0; i < distance.length; i++) {
            if (i >= l && i < r) {
                d1 += distance[i];
            } else {
                d2 += distance[i];
            }
        }
        return Math.min(d1, d2);
    }

    //环形公交路线上有n个站，按次序从0到n - 1进行编号。我们已知每一对相邻公交站之间的距离，
    // distance[i]表示编号为i的车站和编号为(i + 1) % n的车站之间的距离。
    //环线上的公交车都可以按顺时针和逆时针的方向行驶。
    //返回乘客从出发点start到目的地destination之间的最短距离。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode.cn/problems/distance-between-bus-stops
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        //要么正向走，要么逆向走，要么都走，要么都不走
        //正向走：从start到destination的距离是最小的
        //逆向走：从destination到start的距离是最小的
        int n = distance.length;
        int l = Math.min(start, destination);
        int r = Math.max(start, destination);
        //正向走的距离
        int forward = 0;
        //逆向走的距离
        int backward = 0;

        for (int i = 0; i < n; i++) {
            if (i >= l && i < r) {
                forward += distance[i];
            } else {
                backward += distance[i];
            }

        }
        return Math.min(forward, backward);

    }

    public static void main(String[] args) {
        Test24 test24 = new Test24();
        int[] distance = {1, 2, 3, 4};
        System.out.println(test24.distanceBetweenBusStops(distance, 0, 1));
        System.out.println(test24.distanceBetweenBusStops(distance, 0, 2));
        //[7,10,1,12,11,14,5,0]
        int[] distance2 = {7, 10, 1, 12, 11, 14, 5, 0};
        System.out.println(test24.distanceBetweenBusStops1(distance2, 7, 2));
        System.out.println(test24.distanceBetweenBusStops(distance2, 7, 2));
    }
}
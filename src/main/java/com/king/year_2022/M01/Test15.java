package com.king.year_2022.M01;

import com.king.util.Helper;
import com.king.util.MyPrint;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode_diary
 * @description: 539. 最小时间差
 * https://leetcode-cn.com/problems/minimum-time-difference/
 * @author: King
 * @create: 2022-01-16 10:02
 */
public class Test15 {
    public static void main(String[] args) {
        Test15 test15 = new Test15();
        MyPrint.print(test15.findMinDifference1(Helper.getList("00:00", "23:59", "00:02", "12:12")));
        MyPrint.print(test15.findMinDifference2(Helper.getList("00:00", "23:59", "00:02", "12:12")));

    }

    //给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
    //
    // 输入：timePoints = ["00:00","23:59","00:00"]

    //执行用时： 3 ms , 在所有 Java 提交中击败了 77.73% 的用户 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 89.35% 的用户
    public int findMinDifference1(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440) {
            return 0;
        }
        int[] times = new int[n];
        for (int i = 0; i < n; ++i) {
            String[] s = timePoints.get(i).split(":");
            times[i] = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        }
        Arrays.sort(times);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {
            min = Math.min(min, times[i] - times[i - 1]);
        }
        return Math.min(min, times[0] + 1440 - times[times.length - 1]);
    }

    public int findMinDifference2(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        int[] arr = new int[timePoints.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(timePoints.get(i).substring(0, 2)) * 60 +
                    Integer.parseInt(timePoints.get(i).substring(3));
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i] - arr[i - 1]);
        }
        return Math.min(min, arr[0] + 1440 - arr[arr.length - 1]);
    }

    public static void run() {
        BigInteger bigInteger = BigInteger.valueOf(1);
        for (int i = 1; i <= 1000; ++i) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        //问题一：
        //1000的阶乘末尾有多少个0？
        char[] chs = bigInteger.toString().toCharArray();
        for (int i = chs.length - 1; i >= 0; --i) {
            if (chs[i] != '0') {
                System.out.printf("1000的阶乘末尾有%d个0\n", chs.length - i - 1);
                break;
            }
        }
        //问题二：
        //1000的阶乘有多少位数？
        System.out.printf("1000的阶乘有%d位数\n", bigInteger.toString().length());
        //问题三：
        //1000的阶乘的值是多少？
        System.out.println("1000的阶乘的值是: " + bigInteger);
    }
}

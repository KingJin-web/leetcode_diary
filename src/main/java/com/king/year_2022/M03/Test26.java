package com.king.year_2022.M03;

/**
 * @program: leetcode_diary
 * @description: 682. 棒球比赛
 * https://leetcode-cn.com/problems/baseball-game/
 * @author: King
 * @create: 2022-03-26 23:24
 */
public class Test26 {
    public int calPoints(String[] ops) {
        int[] arr = new int[ops.length];
        int i = 0;
        for (String s : ops) {
            switch (s) {
                case "+":
                    arr[i] = arr[i - 1] + arr[i - 2];
                    i++;
                    break;
                case "D":
                    arr[i] = 2 * arr[i - 1];
                    i++;
                    break;
                case "C":
                    arr[i - 1] = 0;
                    i--;
                    break;
                default:
                    arr[i] = Integer.parseInt(s);
                    i++;
            }
        }
        int sum = 0;
        for (int k : arr) {
            sum += k;
        }
        return sum;
    }
}

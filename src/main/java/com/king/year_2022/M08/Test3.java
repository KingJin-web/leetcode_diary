package com.king.year_2022.M08;

import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年08月03日 08:39
 * @description: 899. 有序队列
 * https://leetcode.cn/problems/orderly-queue/
 */
public class Test3 {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String smallest = s;
            StringBuilder sb = new StringBuilder(s);
            int n = s.length();
            for (int i = 1; i < n; i++) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                if (sb.toString().compareTo(smallest) < 0) {
                    smallest = sb.toString();
                }
            }
            return smallest;
        } else {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        String s = "cba";
        int k = 3;
        MyPrint.println(test3.orderlyQueue(s, k));
    }
}
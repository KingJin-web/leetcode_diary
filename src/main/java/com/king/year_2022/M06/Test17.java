package com.king.year_2022.M06;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: 12613
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M06.Test17
 * @date: 2022年06月17日 21:12
 * @description: ${}
 */
public class Test17 {
    public void duplicateZeros(int[] arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = arr.length;
        for (int j : arr) {
            if (j == 0) dq.add(0);
            dq.add(j);
        }
        for (int i = 0 ; i < n ; i++){
            arr[i] = dq.pollFirst();
        }
    }

    public static void main(String[] args) {

    }
}
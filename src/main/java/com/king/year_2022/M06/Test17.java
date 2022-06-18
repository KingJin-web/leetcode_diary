package com.king.year_2022.M06;

import com.king.util.MyPrint;

import java.util.*;

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
        Map<String, String> aa = new HashMap<>();

        Map<String, String>[] a = new HashMap[6];
        for (int i = 0;i<a.length;++i){
            a[i] = new HashMap<>();
            a[i].put("1","2");
            a[i].put("2","2");
            a[i].put("3","2");
        }
        System.out.println(Arrays.toString(a));

    }
}
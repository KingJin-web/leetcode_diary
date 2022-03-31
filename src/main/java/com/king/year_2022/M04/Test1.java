package com.king.year_2022.M04;

import com.king.util.MyPrint;

import java.util.*;

/**
 * @program: leetcode_diary
 * @description: 954. 二倍数对数组
 * @author: King
 * @create: 2022-04-01 01:04
 */
public class Test1 {
    //给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，
    // 都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        if (cnt.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }

        List<Integer> vals = new ArrayList<Integer>();
        for (int x : cnt.keySet()) {
            vals.add(x);
        }
        Collections.sort(vals, (a, b) -> Math.abs(a) - Math.abs(b));

        for (int x : vals) {
            if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) { // 无法找到足够的 2x 与 x 配对
                return false;
            }
            cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
        }
        return true;
    }
    public boolean canReorderDoubled1(int[] arr) {
        Arrays.sort(arr);
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                c -= arr[i];
            } else {
                c += arr[i];
            }
        }
        return c == 0;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int[] arr = {-2, -1, 1, 2};
        int[] arr1 = {4, -2, 2, -4};
        MyPrint.print(test1.canReorderDoubled(arr));
        MyPrint.print(test1.canReorderDoubled(arr1));
    }
}

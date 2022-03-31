package com.king.year_2022.M03;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode_diary
 * @description:
 * @author: King
 * @create: 2022-03-31 23:40
 */
public class Test31 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int curNum = i;
            if (check(curNum)) res.add(curNum);
        }
        return res;
    }

    boolean check(int num) {
        int tmp = num;
        while (tmp > 0) {
            int i = tmp % 10;
            if (i == 0 || num % i != 0) return false;
            tmp /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        Test31 test31 = new Test31();
        System.out.println(test31.selfDividingNumbers(1, 22));
    }
}

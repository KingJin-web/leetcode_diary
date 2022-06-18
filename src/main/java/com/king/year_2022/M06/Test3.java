package com.king.year_2022.M06;

/**
 * @author: King
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M06.Test3
 * @date: 2022年06月03日 23:58
 * @description: ${}
 */
public class Test3 {
    public int consecutiveNumbersSum(int n) {
        /**
         两个元素
         9 = 4 + 5
         = 3*2 + (1 + 2)

         15 = 7 + 8
         = 6 * 2 + (1 + 2)
         = 4 + 5 + 6
         = 3 * 3 + (1 + 2 + 3)
         */
        int cnt = 0;
        for (int i = 1; (long) (i + 1) * i / 2 <= n; i++) {
            if ((n - (i + 1) * i / 2) % i == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
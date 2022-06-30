package com.king.year_2022.M06;

import com.king.util.MyPrint;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年06月29日 23:28
 * @description: 1175. 质数排列
 */
public class Test30 {
    public int numPrimeArrangements(int n) {
        int sum = 0;
        if (n > 2){
            sum = fun(n);
        }else {
            return 1;
        }
        long cur = 1L;
        for (int i = 2;i <= sum; i++){
            cur = (cur * i) % (1000000000 + 7);
        }
        for (int i = 2;i <= n - sum; i++){
            cur = (cur * i) % (1000000000 + 7);
        }
        return  (int)cur;
    }

    public int fun (int n){
        n += 1;
        int sum = 0;
        boolean[] bool = new boolean[n+1];
        for (int i = 2;i < n; i++){
            if (!bool[i]){
                sum ++;
                for (int j = 2; j*i < n; j++) {
                    bool[j*i] = true;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Test30 test30 = new Test30();
        MyPrint.print(test30.numPrimeArrangements(5));
    }
}
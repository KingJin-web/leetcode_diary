package com.king.year_2022.M02;

import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode_diary
 * @description: 1447. 最简分数
 * @author: King
 * @create: 2022-02-10 23:33
 */
public class Test10 {
    //给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。
    // 分数可以以 任意 顺序返回。


    public int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    //执行用时： 19 ms , 在所有 Java 提交中击败了 84.75% 的用户 内存消耗： 42.3 MB , 在所有 Java 提交中击败了 8.87% 的用户
    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) != 1) continue ;
                list.add(i + "/" + j);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Test10 test10 = new Test10();

        MyPrint.printObs(test10.simplifiedFractions(4),test10.simplifiedFractions(3));
    }
}

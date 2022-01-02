package com.king.year_2022.M01;

import java.util.Arrays;

/**
 * @program: leetcode_diary
 * @description: 390. 消除游戏
 * @author: King
 * @create: 2022-01-02 21:29
 */
public class Test2 {
    //执行用时： 2 ms , 在所有 Java 提交中击败了 85.24% 的用户 内存消耗： 37.3 MB ,
    //在所有 Java 提交中击败了 81.43% 的用户




    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }

    public static void main(String[] args) {

    }
}

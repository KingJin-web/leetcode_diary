package com.king.year_2022.M07;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月08日 15:27
 * @description: 1217. 玩筹码
 */
public class Test8 {

    //题目的意思就是，判断chips里奇数多还是偶数多，如果奇数多，返回偶数的个数，如果偶数多，返回奇数的个数
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;
        for (int j : position) {
            if (j % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd, even);
    }

    public static void main(String[] args) {
        Test8 test8 = new Test8();
        int[] position = {1, 2, 3};
        System.out.println(test8.minCostToMoveChips(position));
    }
}
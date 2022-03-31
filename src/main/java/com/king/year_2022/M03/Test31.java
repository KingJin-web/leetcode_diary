package com.king.year_2022.M03;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode_diary
 * @description: 728. 自除数
 * https://leetcode-cn.com/problems/self-dividing-numbers/
 * @author: King
 * @create: 2022-03-31 23:40
 */
public class Test31 {

    //自除数 是指可以被它包含的每一位数整除的数。
    //
    //例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
    //自除数 不允许包含 0 。
    //
    //给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。

    //执行用时： 1 ms , 在所有 Java 提交中击败了 98.33% 的用户 内存消耗： 38.9 MB , 在所有 Java 提交中击败了 45.13% 的用户
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (check(i)) res.add(i);
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

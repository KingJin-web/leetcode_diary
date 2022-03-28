package com.king.year_2022.M03;

/**
 * @program: leetcode_diary
 * @description: 693. 交替位二进制数
 * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
 * @author: King
 * @create: 2022-03-28 21:03
 */
public class Test28 {

    //693. 交替位二进制数
    //给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
    //
    //
    //
    //示例 1：
    //
    //输入：n = 5
    //输出：true
    //解释：5 的二进制表示是：101
    //示例 2：
    //
    //输入：n = 7
    //输出：false
    //解释：7 的二进制表示是：111.
    //示例 3：
    //
    //输入：n = 11
    //输出：false
    //解释：11 的二进制表示是：1011.
    public boolean hasAlternatingBits(int n) {
        int temp = n ^ (n >> 1);
        return (temp & (temp + 1)) == 0;
    }


}

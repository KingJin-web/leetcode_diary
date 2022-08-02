package com.king.year_2022.M08;

import com.king.util.MyPrint;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年08月02日 18:57
 * @description: 1374. 生成每种字符都是奇数个的字符串
 * https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/
 */
public class Test1 {
    //执行用时： 1 ms , 在所有 Java 提交中击败了 66.23% 的用户 内存消耗： 38.8 MB , 在所有 Java 提交中击败了 67.94% 的用户
    public String generateTheString(int n) {
        if (n == 0) {
            return "";
        }
        if (n % 2 == 0) {
            return "a" + generateTheString(n - 1);
        }
        return new String(new char[n]).replace("\0", "b");
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        MyPrint.print(test1.generateTheString(8));
    }
}
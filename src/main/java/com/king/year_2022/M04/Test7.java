package com.king.year_2022.M04;

/**
 * @program: leetcode_diary
 * @description: 796. 旋转字符串
 * @author: King
 * @create: 2022-04-07 23:49
 */
public class Test7 {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }

    public static void main(String[] args) {
        Test7 test7 = new Test7();
    }
}

package com.king.year_2022.M03;

import com.king.util.MyPrint;

/**
 * @program: leetcode_diary
 * @description: 521. 最长特殊序列 Ⅰ
 * @author: King
 * @create: 2022-03-05 23:35
 */
public class Test5 {
    public int findLUSlength(String a, String b) {
        if(a.equals(b)){
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        Test5 test5 = new Test5();
        MyPrint.printObs(test5.findLUSlength());

    }
}

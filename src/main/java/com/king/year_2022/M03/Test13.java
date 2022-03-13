package com.king.year_2022.M03;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

/**
 * @program: leetcode_diary
 * @description: 393. UTF-8 编码验证
 * @author: King
 * @create: 2022-03-13 23:20
 */
public class Test13 {
    public boolean validUtf8(int[] data) {
        int n = 0;
        for (int datum : data) {
            if (n > 0) {
                if (datum >> 6 != 2) return false;
                n--;
            } else if (datum >> 7 == 0) {
                n = 0;
            } else if (datum >> 5 == 0b110) {
                n = 1;
            } else if (datum >> 4 == 0b1110) {
                n = 2;
            } else if (datum >> 3 == 0b11110) {
                n = 3;
            } else {
                return false;
            }
        }
        return n == 0;
    }

    public static void main(String[] args) {
        Test13 test13 = new Test13();
        MyPrint.print(test13.validUtf8(LeetcodeUtil.stringToIntegerArray("[235,140,4]")));
    }
}

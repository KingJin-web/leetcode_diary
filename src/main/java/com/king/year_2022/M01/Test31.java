package com.king.year_2022.M01;

import com.king.util.MyPrint;

/**
 * @program: leetcode_diary
 * @description: 1342. 将数字变成 0 的操作次数
 * @author: King
 * @create: 2022-01-31 23:48
 */
public class Test31 {


        public int numberOfSteps(int num) {
            int ret = 0;
            while (num > 0) {
                ret += (num > 1 ? 1 : 0) + (num & 0x01);
                num >>= 1;
            }
            return ret;
        }

    public static void main(String[] args) {
        Test31 test31 = new Test31();
        MyPrint.printObs(test31.numberOfSteps(12));

    }
}

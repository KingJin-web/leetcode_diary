package com.king.year_2021.M10;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 29. �������
 * https://leetcode-cn.com/problems/divide-two-integers/
 * @author: King
 * @create: 2021/10/12 21:27
 */
public class Test12 {
    private static final int MAX = 2147483647;

    public int divide(int dividend, int divisor) { //���Ƚ���Ԥ����
        if (divisor == 1) return dividend;
        if (divisor == -1) return dividend < MAX * -1 ? MAX : dividend * -1; //��ʼ���
        long res = 0, a = dividend, b = divisor, flag = -1;
        if (a >= 0 && b > 0 || a < 0 && b < 0) flag = 1;
        a = Math.abs(a);
        b = Math.abs(b);
        while (a >= b) {
            a -= b;
            res++;
        }
        return (int) (res * flag);
    }

    public static void main(String[] args) {
        Test12 test11  = new Test12();
        MyPrint.print(test11.divide(10,3));
    }
}
package com.king.year_2021.M11;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 400. �� N λ����
 *
 * @author: King
 * @create: 2021-11-30 22:34
 */
public class Test30 {

    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 34.9 MB , ������ Java �ύ�л����� 96.02% ���û�
    public int findNthDigit(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }

    public static void main(String[] args) {
        Test30 o = new Test30();
        MyPrint.print(o.findNthDigit(11));
    }
}

package com.king.year_2021.M10;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 441. ����Ӳ��
 * https://leetcode-cn.com/problems/arranging-coins/
 * @author: King
 * @create: 2021-10-10 21:15
 */
public class Test10 {
    //ִ����ʱ�� 10 ms , ������ Java �ύ�л����� 17.84% ���û� �ڴ����ģ� 35.6 MB , ������ Java �ύ�л����� 54.82% ���û�
    public int arrangeCoins1(int n) {
        int result = 0;
        int i = 1;
        while (n >= i) {
            n -= i;
            ++result;
            ++i;
        }
        return result;
    }
    /**
     * ��ѧ��ⷨ O(1) �������Ԥ��
     *ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����ģ� 35.7 MB , ������ Java �ύ�л����� 22.41% ���û�
     * @param n
     * @return
     */
    public static int arrangeCoins(int n) {
        return (int) (-1 + Math.sqrt(1 + 8 * (long) n)) / 2;
    }

    /**
     * ������ⷨ O(n)
     *ִ����ʱ�� 8 ms , ������ Java �ύ�л����� 35.69% ���û�
     * �ڴ����ģ� 35.7 MB , ������ Java �ύ�л����� 12.78% ���û�
     * @param n
     * @return
     */
    public static int arrangeCoins2(int n) {
        int i = 1;
        while (n >= i) {
            n -= i;
            i++;
        }
        return i - 1;
    }

    /**
     * ���ֲ��ң�O(log(n / 2 + 1))
     *
     * @param n
     * @return
     */
    public static int arrangeCoins3(int n) {
        long start = 0, end = (long) n / 2 + 1, mid;
        while (end - start > 1) {
            mid = (start + end) >>> 1;
            if (mid * (mid + 1) == (long) 2 * n) {
                return (int) mid;
            } else if (mid * (mid + 1) <= (long) 2 * n) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (end * (end + 1) == (long) 2 * n) ? (int) end : (int) start;
    }
    public static void main(String[] args) {
        Test10 test10 = new Test10();
        MyPrint.print(test10.arrangeCoins(8));
    }
}

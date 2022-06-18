package com.king.year_2021.M08;

import com.king.util.Helper;

/**
 * @program: leetcode
 * @description: 1137. �� N ��̩��������
 * https://leetcode-cn.com/problems/n-th-tribonacci-number/
 * @author: King
 * @create: 2021-08-08 22:46
 */
public class Test8 {
    /*    ̩���������� Tn �������£�
        T0 = 0, T1 = 1, T2 = 1, ���� n >= 0 �������� Tn+3 = Tn + Tn+1 + Tn+2
        �������� n���뷵�ص� n ��̩�������� Tn ��ֵ��*/
    static Test8 test8 = new Test8();

    /**
     * ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����ģ� 35 MB , ������ Java �ύ�л����� 87.57% ���û�
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        int[] T = new int[]{0, 1, 1, 0};
        if (n < 3) {
            return T[n];
        }
        for (int i = 2; i < n; ++i) {
            T[3] = T[0] + T[1] + T[2];
            T[0] = T[1];
            T[1] = T[2];
            T[2] = T[3];
        }
        return T[3];
    }

    public static void main(String[] args) {
        String x="7";
        int y = 2;
        int z=2;
        System.out.println(x+y+z);
        Helper.print(test8.tribonacci(25));
    }
}

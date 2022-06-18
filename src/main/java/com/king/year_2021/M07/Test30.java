package com.king.year_2021.M07;

import com.king.util.Helper;

/**
 * @program: leetcode
 * @description: 70. ��¥��
 * https://leetcode-cn.com/problems/climbing-stairs/
 * @author: King
 * @create: 2021-07-26 10:04
 */
public class Test30 {

    static Test30 t30 = new Test30();

    /**
     * ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����ģ� 34.7 MB , ������ Java �ύ�л����� 99.43% ���û�
     * n=1 1��
     * n=2 2��
     * n=3 3��
     * n=4 5��
     * n=5 8��
     * ��n>3�� f(n) = f(n-1) + f(n-2);
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] f = new int[]{1, 2, 3,};
        if (n <= 3) {
            return f[n - 1];
        }
        for (int i = 2; i < n; ++i) {
            f[2] = f[1] + f[0];
            f[0] = f[1];
            f[1] = f[2];

        }
        return f[2];

    }

    public static void main(String[] args) {
        Helper.print(t30.climbStairs(5));
    }
}

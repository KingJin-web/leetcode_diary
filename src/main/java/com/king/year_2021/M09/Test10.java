package com.king.year_2021.M09;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 600. ��������1�ķǸ�����
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/non-negative-integers-without-consecutive-ones
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-09-11 00:04
 */
public class Test10 {
    //����һ�������� n���ҳ�С�ڻ���� n �ķǸ������У�������Ʊ�ʾ������?������1?�ĸ�����

    //ʾ�� 1:
    //
    //����: 5
    //���: 5
    //����:
    //�����Ǵ�����Ӧ�����Ʊ�ʾ�ķǸ�����<= 5��
    //0 : 0
    //1 : 1
    //2 : 10
    //3 : 11
    //4 : 100
    //5 : 101
    //���У�ֻ������3Υ������������������1��������5���������
    //˵��: 1 <= n <= 109

    //ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 99.26% ���û� �ڴ����ģ� 35.5 MB , ������ Java �ύ�л����� 44.85% ���û�
    public int findIntegers(int num) {
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 32; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int res = 0;
        if ((num & num >> 1) == 0)
            res++;
        int[] binary = new int[32];
        for (int i = 0; i < 32; i++) {
            binary[i] = num % 2;
            num = num / 2;
        }
        for (int i = 31; i >= 0; i--) {
            if (binary[i] == 1) {
                res += dp[i];
                if (i < 31 && binary[i + 1] == 1)
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Test10 test10 = new Test10();
        MyPrint.print(test10.findIntegers(5));
    }
}

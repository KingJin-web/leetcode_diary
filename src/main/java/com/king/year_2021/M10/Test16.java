package com.king.year_2021.M10;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 69. Sqrt(x)
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sqrtx
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-10-17 17:10
 */
public class Test16 {

    //ִ����ʱ�� 55 ms , ������ Java �ύ�л����� 5.12% ���û�
    // �ڴ����ģ� 35.2 MB , ������ Java �ύ�л����� 94.11% ���û�
    public int mySqrt(int x) {
        int a = 1;
        while (x / a >= a) {
            ++a;
        }
        return --a;
    }

    //����һ���Ǹ����� x �����㲢����?x?�� ����ƽ���� ��
    //
    //���ڷ������������������ֻ���� �������� ��С�����ֽ��� ��ȥ ��
    //
    //ע�⣺������ʹ���κ�����ָ����������������� pow(x, 0.5) ���� x ** 0.5 ��
    //

    public static void main(String[] args) {
        Test16 test16 = new Test16();
        MyPrint.print(test16.mySqrt(13));
    }
}

package com.king.year_2021.M09;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 326. 3����
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/power-of-three
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-09-23 14:50
 */
public class Test23 {
    //����һ��������дһ���������ж����Ƿ��� 3���ݴη�������ǣ����� true �����򣬷��� false ��
    //
    //���� n �� 3 ���ݴη������㣺�������� x ʹ�� n == 3x

    //�򵥵ݹ�
    //ִ����ʱ�� 15 ms , ������ Java �ύ�л����� 93.08% ���û�
    //�ڴ����ģ� 37.9 MB , ������ Java �ύ�л����� 91.37% ���û�
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        return (n % 3 == 0) && isPowerOfThree(n / 3);
    }

    //���ܲ�ʹ��ѭ�����ߵݹ�����ɱ�����
    //����Ŀ������ 3232 λ�з��������ķ�Χ�ڣ����� 33 ����Ϊ 3^{19} = 1162261467������ֻ��Ҫ�ж� nn �Ƿ��� 3^{19}��Լ�����ɡ�
    //�뷽��һ��ͬ���ǣ�������Ҫ�����ж� n �Ǹ����� 0 �������
    //ִ����ʱ�� 15 ms , ������ Java �ύ�л����� 93.08% ���û� �ڴ����ģ� 38.2 MB , ������ Java �ύ�л����� 48.36% ���û�
    public boolean isPowerOfThree1(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    //���׹�ʽ
    //ִ����ʱ�� 17 ms , ������ Java �ύ�л����� 21.16% ���û� �ڴ����ģ� 38.1 MB , ������ Java �ύ�л����� 69.48% ���û�
    public boolean isPowerOfThree2(int n) {
        double v = Math.log10(n) / Math.log10(3);
        return v%1 == 0;
    }
    public static void main(String[] args) {
        Test23 test23 = new Test23();
        boolean b = test23.isPowerOfThree(9);
        MyPrint.print(b);
        MyPrint.print(test23.isPowerOfThree2(9));
        MyPrint.print(test23.isPowerOfThree2(99));
    }

}

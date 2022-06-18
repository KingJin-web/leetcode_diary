package com.king.year_2021.M12;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 507. ������
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/perfect-number
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-12-30 23:08
 */
public class Test31 {
    //����һ��?��������������ͳ������������������ ������ ֮����ȣ����ǳ���Ϊ ������������
    //
    //����һ��?����?n��?����������������� true�����򷵻� false
    //
    //?
    //

    //���룺num = 28
    //�����true
    //���ͣ�28 = 1 + 2 + 4 + 7 + 14
    //1, 2, 4, 7, �� 14 �� 28 �����������ӡ�

    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 35 MB , ������ Java �ύ�л����� 83.18% ���û�
    public boolean checkPerfectNumber1(int num) {
        switch (num) {
            case 6:
            case 28:
            case 496:
            case 8128:
            case 33550336:
                return true;
        }
        return false;
    }

    //ִ����ʱ�� 2468 ms , ������ Java �ύ�л����� 5.11% ���û� �ڴ����ģ� 35.2 MB , ������ Java �ύ�л����� 51.02% ���û�
    private boolean checkPerfectNumber(int num) {
        return factor(num) == num;
    }

    public int factor(int k) {
        int i, s = 0;
        for (i = 1; i < k; i++) {
            if (k % i == 0) {
                s += i;
            }
        }
        return s;
    }


    public static void main(String[] args) {
        Test31 test = new Test31();
        MyPrint.print(test.checkPerfectNumber1(28));
        MyPrint.print(test.checkPerfectNumber(28));
        MyPrint.print(test.factor(28));
    }


}

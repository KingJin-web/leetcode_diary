package com.king.year_2021.M09;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 650. ֻ���������ļ���
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/2-keys-keyboard
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-09-19 23:30
 */
public class Test19 {

    //������±���ֻ��һ���ַ� 'A' ����ÿ�ο��Զ�������±��������ֲ�����
    //
    //Copy All������ȫ����������������±��е������ַ�������������Ʋ����ַ�����
    //Paste��ճ������ճ�� ��һ�� ���Ƶ��ַ���
    //����һ������n ������Ҫʹ�����ٵĲ����������ڼ��±������ ǡ��n�� 'A' �������ܹ���ӡ��n�� 'A' �����ٲ���������

    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 35.5 MB , ������ Java �ύ�л����� 16.35% ���û�
    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Test19 test19 = new Test19();

        //���룺3
        //�����3
        //���ͣ�
        //���, ֻ��һ���ַ� 'A'��
        //�� 1 ��, ʹ�� Copy All ������
        //�� 2 ��, ʹ�� Paste ��������� 'AA'��
        //�� 3 ��, ʹ�� Paste ��������� 'AAA'��
        MyPrint.print(test19.minSteps(3));
    }

}

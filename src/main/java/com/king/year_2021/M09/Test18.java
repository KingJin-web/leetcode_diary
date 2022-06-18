package com.king.year_2021.M09;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 292. Nim ��Ϸ
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/nim-game
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-09-18 10:24
 */
public class Test18 {
    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û�
    //�ڴ����ģ� 35.3 MB , ������ Java �ύ�л����� 6.47% ���û�
    public boolean canWinNim(int n) {
        return (n & 3) >= 1;
    }

    //������������������ ���� return n % ( ��� + ��С ) != 0 ����
    //������𰸶̣��һ�������ֱ�� return true ����
    public boolean canWinNim1(int n) {
        return n % 4 != 0;
    }
    public static void main(String[] args) {
        Test18 test18 = new Test18();
        MyPrint.print(test18.canWinNim(4));
        MyPrint.print(test18.canWinNim(2));
    }

//���������ѣ�������һ����Nim ��Ϸ��
//
//��������һ��ʯͷ��
//�������������Լ��Ļغϣ�����Ϊ���֡�
//ÿһ�غϣ��ֵ������õ�1 - 3 ��ʯͷ��
//�õ����һ��ʯͷ���˾��ǻ�ʤ�ߡ�
//��������ÿһ���������Ž⡣���дһ�����������ж����Ƿ�����ڸ���ʯͷ����Ϊ n �������Ӯ����Ϸ���������Ӯ������ true�����򣬷��� false ��


}
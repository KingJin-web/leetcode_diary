package com.king.year_2021.M08;

import com.king.util.Helper;

/**
 * @program: leetcode
 * @description: 541. ��ת�ַ��� II
 * https://leetcode-cn.com/problems/reverse-string-ii/
 * @author: King
 * @create: 2021-08-20 10:11
 */
public class Test20 {

    /**
     * ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����ģ� 38.4 MB , ������ Java �ύ�л����� 62.81% ���û�
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        int ln = s.length() - 1;

        char[] chars = s.toCharArray();
        for (int i = 0; i <= ln; i += 2 * k) {
            //�������ж�β��������k����ȡ��endָ���λ��
            int end = Math.min(ln, i + k - 1);
            //��������㷴ת
            changArrays(chars, i, end);
        }
        return new String(chars);
    }

    public void changArrays(char[] chars, int left, int right) {
        while (left < right) {
            char ch = chars[left];
            chars[left] = chars[right];
            chars[right] = ch;
            ++left;
            --right;
        }
    }

    public static void main(String[] args) {
        Test20 test20 = new Test20();
        Helper.print(test20.reverseStr("abcdefg", 2));
        //�����"bacdfeg"
        Helper.print(test20.reverseStr("abcd", 4));
        //�����"dcba"
    }
}

package com.king.year_2021.M11;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 520. ����д��ĸ
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/detect-capital
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-12-01 01:10
 */
public class Test13 {
//���Ƕ��壬���������ʱ�����ʵĴ�д�÷�����ȷ�ģ�
//
//ȫ����ĸ���Ǵ�д������ "USA" ��
//������������ĸ�����Ǵ�д������ "leetcode" ��
//������ʲ�ֻ����һ����ĸ��ֻ������ĸ��д��?����?"Google" ��
//����һ���ַ��� word �������д�÷���ȷ������ true �����򣬷��� false ��
//

    //ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 94.63% ���û� �ڴ����ģ� 36.9 MB , ������ Java �ύ�л����� 11.22% ���û�
    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        int upper = 0;//��д��ĸ����
        for (char ch : chars) {
            if (Character.isUpperCase(ch)) {
                ++upper;
            }
        }
        if (upper == chars.length) {
            return true;
        } else if (upper == 0) {
            return true;
        } else return Character.isUpperCase(chars[0]) && upper == 1;
    }

    public static void main(String[] args) {
        Test13 test13 = new Test13();
        MyPrint.print(test13.detectCapitalUse("SKT"));
        MyPrint.print(test13.detectCapitalUse("Google"));
    }

    public boolean detectCapitalUse1(String word) {
        char[] cs = word.toCharArray();
        int upper = 0;//��д��ĸ����
        int lower = 0;//Сд��ĸ����
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= 'a') {
                lower++;
            } else {
                upper++;
            }
        }
        if (upper == cs.length) { //ȫ��д
            return true;
        }
        if (lower == cs.length) {//ȫСд
            return true;
        }
        if (upper == 1 && cs[0] < 'a') {//����ĸ��д
            return true;
        }
        return false;
    }
}

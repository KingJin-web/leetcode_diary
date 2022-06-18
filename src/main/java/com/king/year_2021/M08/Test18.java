package com.king.year_2021.M08;

import com.king.util.Helper;

/**
 * @program: leetcode
 * @description: 58. ���һ�����ʵĳ���
 * ����һ���ַ��� s�������ɵ�����ɣ�����ǰ����һЩ�ո��ַ������������ַ��������һ�����ʵĳ��ȡ�
 * <p>
 * ���� ��ָ������ĸ��ɡ��������κοո��ַ���������ַ�����
 * @author: King
 * @create: 2021-08-18 23:18
 */
public class Test18 {
//    ���룺s = "   fly me   to   the moon  "
//    �����4

    //����api
    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 36.7 MB , ������ Java �ύ�л����� 43.29% ���û�
    public int lengthOfLastWord1(String s) {
        s = s.trim();
        return s.substring(s.lastIndexOf(' ') + 1).length();
    }

    //ʹ��split
    //ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 37.67% ���û� �ڴ����ģ� 36.9 MB , ������ Java �ύ�л����� 17.59% ���û�
    public int lengthOfLastWord2(String s) {
        String[] strings = s.split(" ");
        int ln = strings.length - 1;
        while (strings[ln] != null) {
            return strings[ln--].length();
        }
        return 0;
    }

    //��������������ӵ�һ�����ǿո���ַ���ʼ������һ����ʼ�������������ո�ͽ�����
    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 36.8 MB , ������ Java �ύ�л����� 30.39% ���û�
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) continue;
                break;
            }
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        Test18 test18 = new Test18();
        Helper.print(test18.lengthOfLastWord("   fly me   to   the moon  "));
        ;
    }
}

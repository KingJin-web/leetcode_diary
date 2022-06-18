package com.king.year_2021.M09;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 58. ���һ�����ʵĳ���
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/length-of-last-word
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-09-21 18:26
 */
public class Test21 {
    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 36.6 MB , ������ Java �ύ�л����� 60.96% ���û�
    public int lengthOfLastWord(String s) {

        char[] chars = s.trim().toCharArray();

        int ln = chars.length;
        int c = 0;
        for (int i = ln - 1; i >= 0; --i) {
            if (chars[i] == ' ') {
                return c;
            } else {
                ++c;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Test21 test21 = new Test21();
//        MyPrint.print(test21.lengthOfLastWord("Hello World"));
//        MyPrint.print(test21.lengthOfLastWord("   fly me   to   the moon  "));
        MyPrint.print(test21.lengthOfLastWord("a"));

    }
    //����һ���ַ��� s�������ɵ�����ɣ�����ǰ����һЩ�ո��ַ������������ַ��������һ�����ʵĳ��ȡ�
    //
    //���� ��ָ������ĸ��ɡ��������κοո��ַ���������ַ�����


}

package com.king.year_2021.M09;

import com.king.util.Helper;
import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 1961. ����ַ����Ƿ�Ϊ����ǰ׺
 * @author: King
 * @create: 2021-09-09 09:43
 */
public class Test7 {
    //����һ���ַ��� s ��һ���ַ������� words �������ж� s �Ƿ�Ϊ words �� ǰ׺�ַ��� ���ַ��� s Ҫ��Ϊ words �� ǰ׺�ַ��� ��
    // ��Ҫ���㣺s ������ words �е�ǰ k��k Ϊ ���� �����ַ�����˳�������õ����� k ������ words.length ��
    // ��� s �� words �� ǰ׺�ַ��� ������ true �����򣬷��� false ��
    // ��Դ�����ۣ�LeetCode�� ���ӣ�https://leetcode-cn.com/problems/check-if-string-is-a-prefix-of-array ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������

    //ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 97.81% ���û� 
    //�ڴ����ģ� 38.6 MB , ������ Java �ύ�л����� 7.33% ���û�
    public boolean isPrefixString1(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String world : words) {
            sb.append(world);
            if (s.equals(sb.toString())) {
                return true;
            }
        }
        return false;
    }

    //ִ����ʱ�� 2 ms , ������ Java �ύ�л����� 7.68% ���û� �ڴ����ģ� 37.9 MB , ������ Java �ύ�л����� 99.65% ���û�
    public boolean isPrefixString(String s, String[] words) {
        String sb = "";
        for (String world : words) {
            sb+=world;
            if (s.equals(sb)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        ���룺s = "iloveleetcode", words = ["i","love","leetcode","apples"]
//        �����true
        Test7 test7 = new Test7();
        String s = "iloveleetcode";
        MyPrint.print(test7.isPrefixString(s, Helper.getArrays("i", "love", "leetcode", "apples")));
        MyPrint.print(test7.isPrefixString1(s, Helper.getArrays("i", "love", "leetcode", "apples")));
    }
}

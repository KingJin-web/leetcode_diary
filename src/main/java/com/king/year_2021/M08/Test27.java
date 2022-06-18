package com.king.year_2021.M08;

import com.king.util.Helper;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 1805. �ַ����в�ͬ��������Ŀ
 * ���ӣ�https://leetcode-cn.com/problems/number-of-different-integers-in-a-string
 * @author: King
 * @create: 2021-08-27 00:19
 */
public class Test27 {
//    ����һ���ַ��� word �����ַ��������ֺ�СдӢ����ĸ��ɡ�
//
//    �����ÿո��滻ÿ���������ֵ��ַ������磬"a123bc34d8ef34" ������ " 123 34 8 34" ��ע�⣬ʣ�µ���Щ����Ϊ�����ڱ˴�������һ���ո��������"123"��"34"��"8" �� "34" ��
//
//    ���ض� word ����滻���γɵ� ��ͬ ��������Ŀ��
//
//    ֻ�е����������� ����ǰ���� ��ʮ���Ʊ�ʾ��ͬ�� ����Ϊ����������Ҳ��ͬ��
//
//    ��Դ�����ۣ�LeetCode��
//
//    ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������


    //ִ����ʱ�� 3 ms , ������ Java �ύ�л����� 73.14% ���û� �ڴ����ģ� 38.6 MB , ������ Java �ύ�л����� 17.15% ���û�
    public int numDifferentIntegers(String word) {
        char[] chars = word.toCharArray();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 57 || chars[i] < 48) {
                chars[i] = ' ';
            }
        }
        String[] strs = new String(chars).split(" ");
        for (String s : strs) {
            if (!s.equals("")) {
                set.add(delete(s));
            }
        }
        return set.size();
    }

    public String delete(String s){
        if (s.startsWith("0")){
            return delete(s.substring(1));
        }else {
            return s;
        }
    }
    public static void main(String[] args) {
        Test27 test27 = new Test27();
        Helper.print(test27.numDifferentIntegers("a123bc34d8ef34"));
        Helper.print(test27.numDifferentIntegers("a1b01c001"));
    }
}

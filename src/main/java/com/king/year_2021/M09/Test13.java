package com.king.year_2021.M09;

import com.king.util.MyPrint;
import com.king.util.LeetcodeUtil;

import java.util.*;

/**
 * @program: leetcode
 * @description: 524. ͨ��ɾ����ĸƥ�䵽�ֵ��������
 * https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 * @author: King
 * @create: 2021-09-14 10:01
 */
public class Test13 {
    static List<String> strings = new ArrayList<>();

    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary);
        MyPrint.print(dictionary);
        for (String str : dictionary) {
            char[] chars = str.toCharArray();
            int p = 0;
            for (char c : chars) {
                if ((p = str.indexOf(c, p)) >= 0) {
                    p++;
                }
            }
            System.out.println(p);
        }
        return "";
    }

    //ִ����ʱ�� 12 ms , ������ Java �ύ�л����� 95.31% ���û� �ڴ����ģ� 39.4 MB , ������ Java �ύ�л����� 24.71% ���û�
    public String findLongestWord1(String s, List<String> dictionary) {
        Collections.sort(dictionary);
        MyPrint.print(dictionary);
        String res = "";
        for (String s1 : dictionary) {
            if (s1.length() > s.length()) {
                continue;
            }
            int p = 0;
            for (int i = 0; i < s1.length(); i++) {
                p = s.indexOf(s1.charAt(i), p);
                if (p == -1) {
                    break;
                }else p++;
            }
            if (p != -1 && s1.length() > res.length()) {
                res = s1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Test13 test13 = new Test13();
        String s = "abpcplea";

        String[] ss = LeetcodeUtil.stringToStringArray("[\"ale\",\"apple\",\"monkey\",\"plea\"]");
        List<String> dictionary = Arrays.asList(ss);
        MyPrint.print(test13.findLongestWord(s,dictionary));


//        strings.add("aa");
//        strings.add("ab");
//        strings.add("ad");
//        strings.add("ac");
//        MyPrint.print(strings);
//        strings.sort(new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return s1.compareTo(s2);
//            }
//        });
//        MyPrint.print(strings);
    }
}

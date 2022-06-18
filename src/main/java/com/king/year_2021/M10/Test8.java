package com.king.year_2021.M10;

import com.king.util.MyPrint;

import java.util.*;

/**
 * @program: leetcode
 * @description: 187. �ظ���DNA����
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/repeated-dna-sequences
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-10-08 22:58
 */
public class Test8 {
    //���� DNA ����һϵ����дΪ 'A'��'C'��'G' �� 'T' �ĺ�������ɣ����磺"ACGAATTCCG"�����о� DNA ʱ��ʶ�� DNA �е��ظ�������ʱ����о��ǳ��а�����
    //
    //��дһ���������ҳ�����Ŀ���Ӵ���Ŀ���Ӵ��ĳ���Ϊ 10������ DNA �ַ��� s �г��ִ�������һ�Ρ�
    //


    //ִ����ʱ�� 16 ms , ������ Java �ύ�л����� 80.67% ���û� �ڴ����ģ� 46.5 MB , ������ Java �ύ�л����� 84.51% ���û�
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if (len < 10) return new ArrayList<>();
        Set<String> res = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 10; i <= len; ++i) {
            String sub = s.substring(i - 10, i);
            //MyPrint.print(sub);
            if (map.containsKey(sub)) {
                res.add(sub);
            } else {
                map.put(sub, null);
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        Test8 test8 = new Test8();
        MyPrint.print(test8.findRepeatedDnaSequences(s));
    }
}

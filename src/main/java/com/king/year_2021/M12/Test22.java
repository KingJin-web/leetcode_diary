package com.king.year_2021.M12;

import com.king.util.MyPrint;

import java.util.Random;

/**
 * @program: leetcode
 * @description: 686. �ظ������ַ���ƥ��
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/repeated-string-match
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-12-22 23:32
 */
public class Test22 {
    //���������ַ���a �� b��Ѱ���ظ������ַ��� a ����С������ʹ���ַ��� b ��Ϊ���Ӻ���ַ��� a ���Ӵ�������������򷵻� -1��
    //
    //ע�⣺�ַ��� "abc"�ظ����� 0 ���� ""���ظ����� 1 ����"abc"���ظ����� 2 ����"abcabc"��

    public static void main(String[] args) {
        //���룺a = "abcd", b = "cdabcdab"
        //�����3
        //���ͣ�a �ظ����������Ϊ "abcdabcdabcd", ��ʱ b �����Ӵ���
        Test22 test22 = new Test22();
        MyPrint.print(test22.repeatedStringMatch("abcd","cdabcdab"));
    }
    static final int kMod1 = 1000000007;
    static final int kMod2 = 1337;

    public int repeatedStringMatch(String a, String b) {
        int an = a.length(), bn = b.length();
        int index = strStr(a, b);
        if (index == -1) {
            return -1;
        }
        if (an - index >= bn) {
            return 1;
        }
        return (bn + index - an - 1) / an + 2;
    }

    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }

        int k1 = 1000000009;
        int k2 = 1337;
        Random random = new Random();
        int kMod1 = random.nextInt(k1) + k1;
        int kMod2 = random.nextInt(k2) + k2;

        long hashNeedle = 0;
        for (int i = 0; i < m; i++) {
            char c = needle.charAt(i);
            hashNeedle = (hashNeedle * kMod2 + c) % kMod1;
        }
        long hashHaystack = 0, extra = 1;
        for (int i = 0; i < m - 1; i++) {
            hashHaystack = (hashHaystack * kMod2 + haystack.charAt(i % n)) % kMod1;
            extra = (extra * kMod2) % kMod1;
        }
        for (int i = m - 1; (i - m + 1) < n; i++) {
            hashHaystack = (hashHaystack * kMod2 + haystack.charAt(i % n)) % kMod1;
            if (hashHaystack == hashNeedle) {
                return i - m + 1;
            }
            hashHaystack = (hashHaystack - extra * haystack.charAt((i - m + 1) % n)) % kMod1;
            hashHaystack = (hashHaystack + kMod1) % kMod1;
        }
        return -1;
    }

}

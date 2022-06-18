package com.king.year_2021.M08;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 1897. ���·����ַ�ʹ�����ַ��������
 * https://leetcode-cn.com/problems/redistribute-characters-to-make-all-strings-equal/
 * @author: King
 * @create: 2021-08-14 14:24
 */
public class Test13 {
    /**
     * ִ����ʱ�� 2 ms , ������ Java �ύ�л����� 98.63% ���û�
     * �ڴ����ģ� 38 MB , ������ Java �ύ�л����� 70.58% ���û�
     *
     * @param words
     * @return
     */
    public boolean makeEqual(String[] words) {

        int[] arr = new int[26];
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                ++arr[ch - 'a'];
            }
        }
        int n = words.length;
        for (int num : arr) {
            if (num % n != 0) {
                return false;
            }
        }
        return true;
    }


}

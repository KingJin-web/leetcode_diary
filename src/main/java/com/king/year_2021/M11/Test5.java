package com.king.year_2021.M11;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 1218. �����������
 * https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 * @author: King
 * @create: 2021-11-05 02:23
 */
public class Test5 {

    //ִ����ʱ�� 34 ms , ������ Java �ύ�л����� 86.80% ���û� �ڴ����ģ� 55.4 MB , ������ Java �ύ�л����� 28.94% ���û�
    public int longestSubsequence(int[] arr, int difference) {
        int max = 1;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int j : arr) {
            Integer val = map.get(j - difference);
            if (val != null) {
                map.put(j, val + 1);
                max = Math.max(max, val + 1);
            } else
                map.put(j, 1);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}

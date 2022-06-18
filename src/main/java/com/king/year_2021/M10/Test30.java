package com.king.year_2021.M10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description: 260. ֻ����һ�ε����� III
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/single-number-iii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-10-30 01:12
 */
public class Test30 {

    //����һ����������?nums������ǡ��������Ԫ��ֻ����һ�Σ���������Ԫ�ؾ��������Ρ� �ҳ�ֻ����һ�ε�������Ԫ�ء�����԰� ����˳�� ���ش𰸡�
    //
    //?
    //
    //���ף�����㷨Ӧ�þ�������ʱ�临�Ӷȡ����ܷ��ʹ�ó����ռ临�Ӷ���ʵ�֣�


    //ִ����ʱ�� 6 ms , ������ Java �ύ�л����� 10.85% ���û� �ڴ����ģ� 39.6 MB , ������ Java �ύ�л����� 8.84% ���û�
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] arr = new int[2];
        int a = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == 1) {
                arr[a++] = m.getKey();
            }
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}

package com.king.year_2021.M10;

import com.king.util.Helper;
import com.king.util.MyPrint;

import java.util.*;

/**
 * @program: leetcode
 * @description: 229. ������ II
 * @author: King
 * @create: 2021-10-22 20:37
 */

public class Test22 {
    //����һ����СΪ n ���������飬�ҳ��������г��ֳ��� ? n/3 ? �ε�Ԫ�ء�

    //ִ����ʱ�� 11 ms , ������ Java �ύ�л����� 28.12% ���û� �ڴ����ģ� 41.3 MB , ������ Java �ύ�л����� 94.25% ���û�
    public List<Integer> majorityElement(int[] nums) {
        int length = nums.length;
        int n = length / 3;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                list.add(entry.getKey());
            }

        }
        return list;
    }

    //ִ����ʱ�� 2 ms , ������ Java �ύ�л����� 53.04% ���û� �ڴ����ģ� 42.6 MB , ������ Java �ύ�л����� 6.66% ���û�
    public List<Integer> majorityElement1(int[] nums) {
        int element1 = 0;
        int element2 = 0;
        int vote1 = 0;
        int vote2 = 0;

        for (int num : nums) {
            if (vote1 > 0 && num == element1) { //�����Ԫ��Ϊ��һ��Ԫ�أ��������1
                vote1++;
            } else if (vote2 > 0 && num == element2) { //�����Ԫ��Ϊ�ڶ���Ԫ�أ��������1
                vote2++;
            } else if (vote1 == 0) { // ѡ���һ��Ԫ��
                element1 = num;
                vote1++;
            } else if (vote2 == 0) { // ѡ��ڶ���Ԫ��
                element2 = num;
                vote2++;
            } else { //�������Ԫ�ؾ�����ͬ�����໥����1��
                vote1--;
                vote2--;
            }
        }

        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == element1) {
                cnt1++;
            }
            if (vote2 > 0 && num == element2) {
                cnt2++;
            }
        }
        // ���Ԫ�س��ֵĴ����Ƿ�����Ҫ��
        List<Integer> ans = new ArrayList<>();
        if (vote1 > 0 && cnt1 > nums.length / 3) {
            ans.add(element1);
        }
        if (vote2 > 0 && cnt2 > nums.length / 3) {
            ans.add(element2);
        }

        return ans;
    }


    public static void main(String[] args) {
        Test22 test22 = new Test22();
        MyPrint.print(test22.majorityElement(Helper.getArrays(1, 1, 2, 3, 6, 1, 1)));
    }
}

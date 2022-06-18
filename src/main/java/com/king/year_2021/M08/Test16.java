package com.king.year_2021.M08;


import com.king.util.Helper;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: 349. ��������Ľ���
 * �����������飬��дһ���������������ǵĽ�����
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @author: King
 * @create: 2021-08-16 22:07
 */
public class Test16 {

    /**
     * ִ����ʱ�� 5 ms , ������ Java �ύ�л����� 20.52% ���û� �ڴ����ģ� 38.3 MB , ������ Java �ύ�л����� 88.82% ���û�
     * ִ����ʱ�� 3 ms , ������ Java �ύ�л����� 67.53% ���û� �ڴ����ģ� 38.5 MB , ������ Java �ύ�л����� 75.50% ���û�
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = addSet(nums1);
        Set<Integer> set2 = addSet(nums2);
        return intersectionSet(set1, set2);
    }


    public static Set<Integer> addSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set;
    }

    public static int[] intersectionSet(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() < set2.size()) {
            return intersectionSet(set2, set1);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : set1) {
            if (set2.contains(num)) {
                result.add(num);
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    private static int[] ListToArray(List<Integer> result) {
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    public static int[] intersectionSet1(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() < set2.size()) {
            return intersectionSet1(set2, set1);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : set1) {
            if (set2.contains(num)) {
                result.add(num);
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }


    public static void main(String[] args) {
        Test16 test16 = new Test16();
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        Helper.print(test16.intersection(nums1, nums2));
    }


    //��ͨJava���ϵĵ���
    //ִ����ʱ�� 5 ms , ������ Java �ύ�л����� 20.52% ���û� �ڴ����ģ� 38.4 MB , ������ Java �ύ�л����� 83.03% ���û�
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set1, set2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            list.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        list.retainAll(set2);
        set1 = new HashSet<>(list);
        return set1.stream().mapToInt(i -> i).toArray();
    }

    // ���۾�ͨstream����
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }
}

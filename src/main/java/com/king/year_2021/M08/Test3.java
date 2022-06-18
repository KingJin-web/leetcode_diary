package com.king.year_2021.M08;

import com.king.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: 581. �����������������
 * @author: King
 * @create: 2021-08-03 15:33
 */
public class Test3 {
    static Test3 t3 = new Test3();

    /**
     * ִ����ʱ�� 7 ms , ������ Java �ύ�л����� 55.31% ���û�
     * �ڴ����ģ� 39.2 MB , ������ Java �ύ�л����� 92.33% ���û�
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (arr[i] != nums[i]) {
                list.add(i);
            }
        }
        return list.size() == 0? 0 :list.get(list.size() - 1) - list.get(0) + 1;

    }

    public static void main(String[] args) {
        Helper.print(t3.findUnsortedSubarray(Helper.getArrays(2, 6, 4, 8, 10, 9, 15)));
    }


}

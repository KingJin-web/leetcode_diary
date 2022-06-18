package com.king.year_2021.M11;

import com.king.util.Helper;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 268. ��ʧ������
 * https://leetcode-cn.com/problems/missing-number/
 * @author: King
 * @create: 2021-11-06 01:31
 */
public class Test6 {

    //����һ������ [0, n] �� n ���������� nums ���ҳ� [0, n] �����Χ��û�г����������е��Ǹ�����

    //ִ����ʱ�� 2 ms , ������ Java �ύ�л����� 35.76% ���û� �ڴ����ģ� 38.8 MB , ������ Java �ύ�л����� 59.78% ���û�
    public int missingNumber1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        int a = 0;
        for (int i = 1; i <= n; ++i) {
            a += i;
        }
        return a - sum;
    }

    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 38.9 MB , ������ Java �ύ�л����� 23.15% ���û�
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int a = 0;
        for (int i = 1; i <= n; ++i) {
            a += i;
            sum += nums[i - 1];
        }
        return a - sum;
    }

    public static void main(String[] args) {
        Test6 test6 = new Test6();

        MyPrint.print(test6.missingNumber(Helper.getArrays(9, 6, 4, 2, 3, 5, 7, 0, 1)));
    }
}

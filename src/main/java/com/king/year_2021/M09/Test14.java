package com.king.year_2021.M09;

import com.king.util.MyPrint;
import com.king.util.LeetcodeUtil;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 162. Ѱ�ҷ�ֵ
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-peak-element
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-09-15 00:42
 */
public class Test14 {
    //ִ����ʱ�� 2 ms , ������ Java �ύ�л����� 100.00% ���û�
    //�ڴ����ģ� 38 MB , ������ Java �ύ�л����� 65.63% ���û�
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        for (int i = 0; i < length; ++i) {
            if (max == nums[i]) {
                return i;
            }
        }
        return 0;
    }

    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û�
    //�ڴ����ģ� 37.8 MB , ������ Java �ύ�л����� 93.88% ���û�
    public int findPeakElement1(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û�
    //�ڴ����ģ� 38.1 MB , ������ Java �ύ�л����� 52.09% ���û�
    public int findPeakElement2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        // ���ַ� [l, r] ��Զ��ʾ��ѯ֮����Ȼ���ܵķ�Χ
        while (l < r) {
            int mid = (l + r) / 2;

            // nums[-1] = nums[n] = -��
            if (nums[mid] < nums[mid + 1]) {
                // ��� mid + 1 ���� ˵�� mid ֮��϶�����������mid+1 ֮���з�
                l = mid + 1;
            } else {
                // ��� mid ���� ˵�� mid ֮ǰ�з�
                r = mid;
            }
        }

        // �����˳���ʱ�� l �� r ��ȣ� ������ʼ�ձ��� [l, r] ���з塣 ���ԣ�r���Ƿ����ڵ�λ�á�

        return r;
    }


    public static void main(String[] args) {
        Test14 test14 = new Test14();
        MyPrint.print(test14.findPeakElement(LeetcodeUtil.stringToIntegerArray("[1,2,1,3,5,6,4]")));
        MyPrint.print(test14.findPeakElement(LeetcodeUtil.stringToIntegerArray("[1,2,3]")));
        MyPrint.print(test14.findPeakElement(LeetcodeUtil.stringToIntegerArray("[3,2,1]")));
        MyPrint.print(test14.findPeakElement1(LeetcodeUtil.stringToIntegerArray("[1,2,3]")));
        MyPrint.print(test14.findPeakElement2(LeetcodeUtil.stringToIntegerArray("[1,2,1,3,5,6,4]")));
    }
    //��ֵԪ����ָ��ֵ�ϸ������������ֵ��Ԫ�ء�
    //
    //����һ����������nums���ҵ���ֵԪ�ز�������������������ܰ��������ֵ������������£����� �κ�һ����ֵ ����λ�ü��ɡ�
    //
    //����Լ���nums[-1] = nums[n] = -�� ��
    //
    //�����ʵ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨����������⡣

}

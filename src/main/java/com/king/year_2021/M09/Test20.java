package com.king.year_2021.M09;

import com.king.util.Helper;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 300. �����������
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @author: King
 * @create: 2021-09-20 18:35
 */
public class Test20 {
    //����һ���������� nums ���ҵ�������ϸ���������еĳ��ȡ�
    //
    //���������������������������У�ɾ������ɾ���������е�Ԫ�ض����ı�����Ԫ�ص�˳��
    // ���磬[3,6,2,7] ������ [0,3,1,6,2,2,7] �������С�

    //ִ����ʱ�� 62 ms , ������ Java �ύ�л����� 48.99% ���û� �ڴ����ģ� 37.7 MB , ������ Java �ύ�л����� 95.66% ���û�
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] dp = new int[len];

        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        Test20 test20 = new Test20();
        MyPrint.print(test20.lengthOfLIS(Helper.getArrays(10, 9, 2, 5, 3, 7, 101, 18)));
    }
}

package com.king.year_2021.M08;

import com.king.util.Helper;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 1646. ��ȡ���������е����ֵ
 * https://leetcode-cn.com/problems/get-maximum-in-generated-array
 * @author: King
 * @create: 2021-08-23 23:22
 */
public class Test24 {
    //����һ������ n ����������������һ������Ϊ n + 1 ������ nums ��
    //
    //nums[0] = 0
    //nums[1] = 1
    //�� 2 <= 2 * i <= n ʱ��nums[2 * i] = nums[i]
    //�� 2 <= 2 * i + 1 <= n ʱ��nums[2 * i + 1] = nums[i] + nums[i + 1]
    //������������ nums �е� ��� ֵ��

    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 35.1 MB , ������ Java �ύ�л����� 73.89% ���û�
    private int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; ++i) {
            nums[i] = nums[i / 2] + i % 2 * nums[i / 2 + 1];
        }
        return getArrMax(nums);

    }

    public static int getArrMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }

    public int getMaximumGenerated1(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; ++i) {
            nums[i] = nums[i / 2] + i % 2 * nums[i / 2 + 1];
        }
        return Arrays.stream(nums).max().getAsInt();
    }

    public static void main(String[] args) {
        Test24 test24 = new Test24();
        Helper.print(test24.getMaximumGenerated1(22));
        Helper.print(test24.getMaximumGenerated(22));
    }


}

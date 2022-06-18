package com.king.year_2021.M08;

import com.king.util.Helper;

/**
 * @program: leetcode
 * @description: 413. �Ȳ����л���
 * https://leetcode-cn.com/problems/arithmetic-slices/
 * @author: King
 * @create: 2021-08-11 22:34
 */
public class Test11 {

    static Test11 test11 = new Test11();
    /**
     * ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����ģ� 36.2 MB , ������ Java �ύ�л����� 47.28% ���û�
     *
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int ln = nums.length;
        if (ln < 3) {
            return 0;
        }
        int c = nums[0] - nums[1];
        int count = 0, a, result = 0;
        for (int i = 2; i < ln; ++i) {
            a = nums[i - 1] - nums[i];
            if (a == c) {
                ++count;
            } else {
                c = a;
                count = 0;
            }

            result += count;
        }

        return result;
    }

    public static void main(String[] args) {
        Helper.print(test11.numberOfArithmeticSlices(Helper.getArrays(1,2,3,4)));
    }
}

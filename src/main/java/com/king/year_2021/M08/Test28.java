package com.king.year_2021.M08;

import com.king.util.Helper;

/**
 * @program: leetcode
 * @description: 1480. һά����Ķ�̬��
 * ����һ������ nums �����顸��̬�͡��ļ��㹫ʽΪ��runningSum[i] = sum(nums[0]��nums[i]) ��
 * �뷵�� nums �Ķ�̬�͡�
 * ���ӣ�https://leetcode-cn.com/problems/running-sum-of-1d-array
 * @author: King
 * @create: 2021-08-28 22:39
 */
public class Test28 {
    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 38.5 MB , ������ Java �ύ�л����� 61.07% ���û�
    public int[] runningSum(int[] nums) {
        int ln = nums.length;
        int[] result = new int[ln];
        int count = 0;
        for (int i = 0; i < ln; ++i) {
            result[i] = count+=nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
//        ���룺nums = [3,1,2,10,1]
//        �����[3,4,6,16,17]
        Test28 test28 = new Test28();
        Helper.print(test28.runningSum(Helper.getArrays(3,1,2,10,1)));
    }
}

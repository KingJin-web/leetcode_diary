package com.king.year_2021.M09;

import com.king.util.MyPrint;
import com.king.util.LeetcodeUtil;

/**
 * @program: leetcode
 * @description: 704. ���ֲ���
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/binary-search
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-09-06 22:18
 */
public class Test6 {
    //����һ��n��Ԫ������ģ�������������nums ��һ��Ŀ��ֵtarget ��
    // дһ����������nums�е� target�����Ŀ��ֵ���ڷ����±꣬���򷵻� -1��
    public int search(int[] nums, int target) {
        MyPrint.print(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // int mid = (left + right)/2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Test6 test6 = new Test6();

        //����: nums = [-1,0,3,5,9,12], target = 9
        //���: 4
        //����: 9 ������ nums �в����±�Ϊ 4

        //����: nums = [-1,0,3,5,9,12], target = 2
        //���: -1
        //����: 2 ������ nums ����˷��� -1

        MyPrint.print(test6.search(LeetcodeUtil.stringToIntegerArray("[-1,0,3,5,9,12]"),9));
        MyPrint.print(test6.search(LeetcodeUtil.stringToIntegerArray("[-1,0,3,5,9,12]"),2));
    }

}

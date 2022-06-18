package com.king.year_2021.M10;

import com.king.util.Helper;
import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 496. ��һ������Ԫ�� I
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * @author: King
 * @create: 2021-10-26 23:12
 */
public class Test25 {
    //ִ����ʱ�� 3 ms , ������ Java �ύ�л����� 91.45% ���û�
    //�ڴ����ģ� 38.3 MB , ������ Java �ύ�л����� 94.31% ���û�
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[m];
        for (int i = 0; i < m; ++i) {
            int j = 0;
            while (j < n && nums2[j] != nums1[i]) {
                ++j;
            }
            int k = j + 1;
            while (k < n && nums2[k] < nums2[j]) {
                ++k;
            }
            res[i] = k < n ? nums2[k] : -1;
        }
        return res;
    }

    public static void main(String[] args) {
        Test25 test25 = new Test25();
        MyPrint.print(test25.nextGreaterElement(Helper.getArrays(4,1,2),Helper.getArrays(1,3,4,2)));
    }

}

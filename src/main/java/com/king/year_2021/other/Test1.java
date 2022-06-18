package com.king.year_2021.other;

import com.king.util.Helper;
import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-10-29 16:18
 */
public class Test1 {
    //쳲��������壺F(0)=0��F(1)=1, F( n )=F(n - 1)+F(n - 2)��n �� 2��n�� N*��
    //���ô���ʵ�֣��ж�һ���������飬��ɾ������ɾ��һ����β���֣��������Ƿ�Ϊ�Ʋ���������

    public boolean isFib(int[] nums) {
        int len = nums.length;
        if (nums[0] != 0) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (i + 1 < len && i + 2 < len) {
                if (nums[i + 2] != nums[i] + nums[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[] fib(int n) {
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        MyPrint.print(arr);
        return arr;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        MyPrint.print(test1.isFib(test1.fib(10)));
        MyPrint.print(test1.isFib(Helper.getArrays(1,2,3,4)));
    }

}

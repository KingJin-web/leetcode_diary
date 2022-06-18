package com.king.year_2021.M08;

import com.king.util.Helper;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 1109. ����Ԥ��ͳ��
 * https://leetcode-cn.com/problems/corporate-flight-bookings/
 * @author: King
 * @create: 2021-08-31 14:49
 */
public class Test31 {

    //ִ����ʱ�� 1530 ms , ������ Java �ύ�л����� 13.58% ���û� �ڴ����ģ� 53.4 MB , ������ Java �ύ�л����� 54.06% ���û�
    public int[] corpFlightBookings1(int[][] bookings, int n) {
        int[] arr = new int[n];
        for (int[] nums : bookings) {
            for (int i = nums[0] - 1; i < nums[1]; ++i) {
                arr[i] += nums[2];
            }
        }
        return arr;
    }

    //ִ����ʱ�� 2 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 53 MB , ������ Java �ύ�л����� 83.26% ���û�
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n + 2];

        for (int[] booking : bookings) {
            arr[booking[0]] += booking[2];
            arr[booking[1] + 1] -= booking[2];
        }
        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i - 1];
        }
        return Arrays.copyOfRange(arr, 1, n + 1);
    }

    public static void main(String[] args) {
        Test31 test31 = new Test31();
        //���룺bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
        //�����[10,55,45,25,25]
        //���ͣ�
        //������        1   2   3   4   5
        //Ԥ����¼ 1 ��   10  10
        //Ԥ����¼ 2 ��       20  20
        //Ԥ����¼ 3 ��       25  25  25  25
        //����λ����      10  55  45  25  25
        //��ˣ�answer = [10,55,45,25,25]

        int[][] arrs = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        Helper.print(test31.corpFlightBookings(arrs, 5));

    }
}

package com.king.year_2021.M08;

import com.king.util.Helper;

/**
 * @program: leetcode
 * @description: 1588. ������������������ĺ�
 * https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 * @author: King
 * @create: 2021-08-29 19:29
 */
public class Test29 {
    //����ÿ��Ԫ��i����������ֳ��ֵĴ�������arr[i],�ۼӽ������
    //���Ա���ÿ��Ԫ�ؿ�����ִ���������ģ�Ҫ��ʹ���±�Ϊi��Ԫ�س���
    //���������ȵ�������Ĵ������ڰ���arr[i]��ǰ���£��������ż����Ԫ�أ�
    //�Ҳ����Ϊż����Ԫ�أ���������������Ԫ���Ҳ�Ҳ������������Ԫ��
    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 36.1 MB , ������ Java �ύ�л����� 45.75% ���û�
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            //�±�Ϊiʱ��arr[i]���һ����i��������������ǰ��ѡ��0��1��2...i����
            //����i+1�ֿ��ܣ�i���Ҳ���arr.length - i - 1��Ԫ��
            //������arr.length - i�ֿ���
            int left = i + 1, right = arr.length - i;
            //�������ԣ�ѡ��ż�����ȵ����������Ϊleft/2
            //����Ϊ(left + 1)/2���Ҳ���Ȼ
            int leftOdd = (left + 1) / 2, leftEven = left / 2;
            int rightOdd = (right + 1) / 2, rightEven = right / 2;

            //��ÿ��Ԫ�س�����������������Ĵ����ۼӼ���
            res += (leftOdd * rightOdd + leftEven * rightEven) * arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Test29 test29 = new Test29();
//        ���룺arr = [1,4,2,5,3]
//        �����58
//        ���ͣ�����������������������ǵĺ�Ϊ��
//                [1] = 1
//                [4] = 4
//                [2] = 2
//                [5] = 5
//                [3] = 3
//                [1,4,2] = 7
//                [4,2,5] = 11
//                [2,5,3] = 10
//                [1,4,2,5,3] = 15
//        ���ǽ�����ֵ��͵õ� 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
        int a = test29.sumOddLengthSubarrays(Helper.getArrays(1, 4, 2, 5, 3));
        Helper.print(a);
    }
}

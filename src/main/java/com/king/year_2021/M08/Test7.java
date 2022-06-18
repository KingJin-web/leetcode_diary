package com.king.year_2021.M08;

import com.king.util.Helper;

import java.util.stream.IntStream;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-08-07 15:34
 */
public class Test7 {

    /**
     * ��ָ Offer 64. ��1+2+��+n
     * �� 1+2+...+n ��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
     * https://leetcode-cn.com/problems/qiu-12n-lcof/
     */
    public static class T1 {
        int[] arr = new int[]{0};

        /**
         * ִ����ʱ�� 1918 ms , ������ Java �ύ�л����� 48.47% ���û�
         * �ڴ����ģ� 38.4 MB , ������ Java �ύ�л����� 5.02% ���û�
         * @param n
         * @return
         */
        public int sumNums(int n) {
            try {
                return arr[n];
            }catch (Exception e){
                return n + sumNums(n - 1);
            }
        }

        public int sumNums2(int n) {
            return IntStream.range(1, n + 1).sum();
        }

        public static void main(String[] args) {
            T1 t1 = new T1();
            Helper.print(t1.sumNums(5));
        }
    }
}

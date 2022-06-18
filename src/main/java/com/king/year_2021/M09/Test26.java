package com.king.year_2021.M09;

import com.king.util.MyPrint;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 371. ������֮��
 * https://leetcode-cn.com/problems/sum-of-two-integers/
 * ��������֮�ͣ���žһ���Ӿͽ����˰����ܿ찡������һ�������üӼ��ţ���žһ���Ӿ������˰�
 * @author: King
 * @create: 2021-09-26 22:52
 */
public class Test26 {

    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 35.3 MB , ������ Java �ύ�л����� 17.26% ���û�
    public int getSum1(int a, int b) {
        return a + b;
    }

    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 35 MB , ������ Java �ύ�л����� 84.83% ���û�
    public int getSum(int a,int b){
        int [] arr = {a,b};
        return Arrays.stream(arr).sum();
    }

    public int getSum2(int a, int b) {
        return BigInteger.valueOf(a).add(BigInteger.valueOf(b)).intValue();
    }

    public static void main(String[] args) {
        Test26 test26 = new Test26();
        MyPrint.print(test26.getSum(1,3));
    }
}

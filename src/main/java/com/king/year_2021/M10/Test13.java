package com.king.year_2021.M10;

import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 412. Fizz Buzz
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/fizz-buzz
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-10-13 19:08
 */
public class Test13 {


    //����һ������ n ���ҳ��� 1 �� n ���������� Fizz Buzz ��ʾ�������ַ������� answer���±�� 1 ��ʼ�����ؽ�������У�
    //
    //answer[i] == "FizzBuzz" ��� i ͬʱ�� 3 �� 5 �ı�����
    //answer[i] == "Fizz" ��� i �� 3 �ı�����
    //answer[i] == "Buzz" ��� i �� 5 �ı�����
    //answer[i] == i �����������ȫ�����㡣


    //ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 99.43% ���û� �ڴ����ģ� 39.4 MB , ������ Java �ύ�л����� 83.99% ���û�
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        String[] chart = new String[]{"FizzBuzz", "", "", "Fizz", "", "Buzz", "Fizz", "", "", "Fizz", "Buzz", "", "Fizz", "", ""};
        for (int i = 1; i <= n; i++) {
            if (chart[i % 15].equals(""))
                result.add(Integer.toString(i));
            else
                result.add(chart[i % 15]);
        }
        return result;
    }

    //ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 99.43% ���û� �ڴ����ģ� 39.7 MB , ������ Java �ύ�л����� 33.12% ���û�
    public List<String> fizzBuzz1(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Test13 test13 = new Test13();
        MyPrint.print(test13.fizzBuzz(3));
    }

}

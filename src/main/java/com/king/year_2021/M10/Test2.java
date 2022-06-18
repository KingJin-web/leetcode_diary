package com.king.year_2021.M10;

import com.king.util.MyPrint;

import java.time.LocalDateTime;

/**
 * @program: leetcode
 * @description: 405. ����ת��Ϊʮ��������
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-10-02 16:30
 */
public class Test2 {
    //����һ����������дһ���㷨�������ת��Ϊʮ�������������ڸ�����������ͨ��ʹ��?��������?������
    //
    //ע��:
    //
    //ʮ��������������ĸ(a-f)��������Сд��
    //ʮ�������ַ����в��ܰ��������ǰ���㡣���Ҫת������Ϊ0����ô�Ե����ַ�'0'����ʾ���������������ʮ�������ַ����еĵ�һ���ַ���������0�ַ���?
    //��������ȷ����32λ�з���������Χ�ڡ�
    //����ʹ���κ��ɿ��ṩ�Ľ�����ֱ��ת�����ʽ��Ϊʮ�����Ƶķ�����


    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 35.9 MB , ������ Java �ύ�л����� 9.89% ���û�
    public String toHex(int num) {
        return Integer.toHexString(num);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        MyPrint.print(test2.toHex(26));
    }
}

package com.king.year_2021.M07;

import com.king.util.Helper;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 1736. �滻�������ֵõ�������ʱ��
 * https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits/
 * @author: King
 * @create: 2021-07-24 09:17
 */
public class Test26 {
//    ����һ���ַ��� time ����ʽΪ hh:mm��Сʱ�����ӣ�������ĳ��λ���ֱ����أ��� ? ��ʾ����
//    ��Ч��ʱ��Ϊ 00:00 �� 23:59 ֮�������ʱ�䣬���� 00:00 �� 23:59 ��
//    �滻 time �����ص����֣���������Եõ���������Чʱ�䡣

    /**
     * ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����ģ� 36.7 MB , ������ Java �ύ�л����� 40.79% ���û�
     *
     * @param time
     * @return
     */
    public String maximumTime(String time) {

        char[] chars = time.toCharArray();
        if (chars[0] == '?') {
            if (chars[1] == '?') {
                chars[0] = '2';
                chars[1] = '3';
            } else {
                if (chars[1] <= '3') {
                    chars[0] = '2';
                } else {
                    chars[0] = '1';
                }
            }
        }
        if (chars[1] == '?') {
            if (chars[0] == '0' || chars[0] == '1') {
                chars[1] = '9';
            } else {
                chars[1] = '3';
            }
        }
        Helper.print(Arrays.toString(chars));
        if (chars[3] == '?') chars[3] = '5';
        if (chars[4] == '?') chars[4] = '9';
        return new String(chars);

    }

    public static void main(String[] args) {
        Test26 t26 = new Test26();
        Helper.print(t26.maximumTime("2?:??"));
        Helper.print(t26.maximumTime("?0:15"));
        Helper.print(t26.maximumTime("??:3?"));
        Helper.print(t26.maximumTime("?0:15"));
    }
}

package com.king.year_2021.M08;

import com.king.util.Helper;

import com.king.year_2021.MyAssert;

/**
 * @program: leetcode
 * @description: 6. Z ���α任
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * @author: King
 * @create: 2021-08-11 00:17
 * �����һ��4�е�
 * 0     6      12        18
 * 1   5 7   11 13    17
 * 2 4   8 10   14 16
 * 3     9      15
 */
public class Test10 {
//    public String convert(String s, int numRows) {
//        //��s�ĳ���С������ʱ��ֱ�ӷ���s
//        //������Ϊ1ʱ��Ҳֱ�ӷ���s
//        if (s.length() < numRows || numRows == 1) {
//            return s;
//        }
//        int segment = 2 * numRows - 2;
//        StringBuilder stb = new StringBuilder(s.length());
//        // ���ͷ
//        for (int i = 0; i * segment < s.length(); i++) {
//            stb.append(s.charAt(i * segment));
//        }
//
//
//        return stb.toString();
//    }

    /**
     * ִ����ʱ�� 2 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����ģ� 38.3 MB , ������ Java �ύ�л����� 97.51% ���û�
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        //��s�ĳ���С������ʱ��ֱ�ӷ���s
        //������Ϊ1ʱ��Ҳֱ�ӷ���s
        int len = s.length();
        if (len < numRows || numRows == 1) {
            return s;
        }

        int segment = 2 * numRows - 2;
        StringBuilder target = new StringBuilder(len);
        // ���ͷ
        for (int i = 0; i * segment < len; ++i) {
            target.append(s.charAt(i * segment));
        }
        // �����
        int l = 0;
        for (int i = 0; i < numRows - 2; ++i) {
            for (int j = 0; j * segment + i + 1 < len; ++j) {
                // ���һ�εĵ�һ��
                target.append(s.charAt(j * segment + i + 1));
                // ���һ�εĵڶ��У�����Ҫ�жϵڶ��ж�Ӧλ���Ƿ���Ԫ�أ�Ҳ�����������ܳ���s�ĳ���
                l = j * segment + (segment - i - 1);

                if (l < len)
                    target.append(s.charAt(l));
            }
        }
        // ���β
        for (int i = 0; i * segment + numRows - 1 < len; i++) {
            target.append(s.charAt(i * segment + numRows - 1));
        }
        return target.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        Test10 test10 = new Test10();
        String a = test10.convert(s, 3);
        MyAssert.assertEquals("PAHNAPLSIIGYIR", a);


        Helper.print(a);

/**
 ���룺s = "PAYPALISHIRING", numRows = 3
 �����"PAHNAPLSIIGYIR"
 ʾ�� 2��
 ���룺s = "PAYPALISHIRING", numRows = 4
 �����"PINALSIGYAHRPI"
 **/
    }
}

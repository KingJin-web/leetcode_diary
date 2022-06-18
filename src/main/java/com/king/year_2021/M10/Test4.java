package com.king.year_2021.M10;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 482. ��Կ��ʽ��
 * https://leetcode-cn.com/problems/license-key-formatting/
 * @author: King
 * @create: 2021-10-05 00:02
 */
public class Test4 {
    //��һ����Կ�ַ��� S ��ֻ������ĸ�������Լ� '-'�����ۺţ������У� N �� '-' ���ַ����ֳ��� N+1 �顣
    //
    //����һ������ K���������¸�ʽ���ַ�����ʹÿ������ǡ�ð��� K ���ַ����ر�أ���һ������������ַ���������С�ڵ��� K��
    // ������Ҫ���� 1 ���ַ�����������֮����Ҫ�� '-'�����ۺţ����������ҽ����е�Сд��ĸת��Ϊ��д��ĸ��
    //
    //�����ǿ��ַ��� S ������ K���������������Ĺ�����и�ʽ����

    //ִ����ʱ�� 51 ms , ������ Java �ύ�л����� 15.24% ���û� �ڴ����ģ� 39 MB , ������ Java �ύ�л����� 23.10% ���û�
    public String licenseKeyFormatting1(String s, int k) {
        StringBuilder sb = new StringBuilder(s.replaceAll("-", "").toUpperCase());
        for (int i = sb.length() - k; i > 0; i -= k) {
            sb.insert(i, '-');
        }
        return sb.toString();
    }

    //ִ����ʱ�� 9 ms , ������ Java �ύ�л����� 85.93% ���û� �ڴ����ģ� 38.5 MB , ������ Java �ύ�л����� 66.47% ���û�
    public String licenseKeyFormatting(String s, int k) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int ln = chars.length;
        int c = 0;
        for (int i = ln - 1; i >= 0; --i) {
            if (chars[i] != '-') {
                ++c;
                sb.append(Character.toUpperCase(s.charAt(i)));
                if (c % k == 0) {
                    sb.append("-");
                }

            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
    public String licenseKeyFormatting3(String s, int k) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int ln = chars.length;
        int c = 0;
        for (int i = ln - 1; i >= 0; --i) {
            if (chars[i] != '-') {
                ++c;
                sb.append(Character.toUpperCase(s.charAt(i)));
                if (c % k == 0) {
                    sb.append("-");
                }

            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        Test4 test4 = new Test4();
        MyPrint.print(test4.licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }
}

package com.king.year_2021.M08;

import com.king.util.Helper;

/**
 * @program: leetcode
 * @description: 443. ѹ���ַ���
 * https://leetcode-cn.com/problems/string-compression/
 * @author: King
 * @create: 2021-08-21 20:32
 */
public class Test22 {

    //ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 98.90% ���û� �ڴ����ģ� 38.2 MB , ������ Java �ύ�л����� 29.76% ���û�
    public int compress1(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }



    public static void main(String[] args) {
        Test22 test22 = new Test22();

        Helper.print(test22.compress1(Helper.getArrays('a','b','b','b','b','b','b','b','b','b','b','b','b')));
        //���룺chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
        //��������� 4 �����������ǰ 4 ���ַ�Ӧ���ǣ�["a","b","1","2"]��
        //���ͣ�
        //�����ַ� "a" ���ظ������Բ��ᱻѹ����"bbbbbbbbbbbb" �� ��b12�� �����
        //ע��ÿ�������������ж������Լ���λ�á�

        Helper.print(test22.compress(Helper.getArrays('a','b','b','b','b','b','b','b','b','b','b','b','b')));
    }

    private int compress(char[] arrays) {


        return 0;
    }

}

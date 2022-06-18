package com.king.year_2021.M10;

import com.king.util.Helper;
import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 66. ��һ
 * https://leetcode-cn.com/problems/plus-one/
 * @author: King
 * @create: 2021-10-21 19:40
 */
public class Test21 {
    //��� digits ��ĩβû�� 9 ��ĩβ������һ
//
//��� digits ��ĩβ�����ɸ� 9ֻ��Ҫ�ҳ���ĩβ��ʼ�ĵ�һ����Ϊ 9 ��Ԫ�أ�����Ԫ�ؼ�һ���õ����ĩβ�� 9 ȫ������
//
//��� digits ������Ԫ�ض��� 9������һ�����ȱ�digits �� 11 �������飬����Ԫ����Ϊ 1������Ԫ����Ϊ 0 ���ɡ�
    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 36.8 MB , ������ Java �ύ�л����� 68.73% ���û�
    public int[] plusOne(int[] digits) {
        int ln = digits.length;
        if (digits[ln - 1] != 9) {
            ++digits[ln - 1];
        } else {
            int i = ln - 1;
            while (digits[i] == 9) {
                if (i == 0) {
                    // digits �����е�Ԫ�ؾ�Ϊ 9
                    int[] ans = new int[ln + 1];
                    ans[0] = 1;
                    return ans;
                }
                digits[i--] = 0;
            }
            ++digits[i];
        }
        return digits;
    }
    public int[] plusOne1(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits �����е�Ԫ�ؾ�Ϊ 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
    public static void main(String[] args) {
        Test21 test21 = new Test21();
        MyPrint.print(test21.plusOne(Helper.getArrays(8, 8, 9, 9)));
    }
}

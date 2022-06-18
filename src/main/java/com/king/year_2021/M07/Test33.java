package com.king.year_2021.M07;

import com.king.util.Helper;

/**
 * @program: leetcode
 * @description: 171. Excel�������
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 * @author: King
 * @create: 2021-07-30 14:26
 */
public class Test33 {
    public static Test33 t33 = new Test33();

    /**
     * ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����ģ� 38.5 MB , ������ Java �ύ�л����� 36.27% ���û�
     *
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        int a = 0;
        char[] chars = columnTitle.toCharArray();
        for (char c : chars) {
            a = a * 26 + (c - 'A' + 1);
        }
        return a;
    }

    public static void main(String[] args) {
        Helper.print(t33.titleToNumber("AB"));
    }
}

package com.king.year_2021.M08;

import com.king.util.Helper;

/**
 * @program: leetcode
 * @description: 551. ѧ�����ڼ�¼ I
 * https://leetcode-cn.com/problems/student-attendance-record-i/
 * @author: King
 * @create: 2021-08-17 00:38
 */
public class Test17 {
    /**
     * ����һ���ַ��� s ��ʾһ��ѧ���ĳ��ڼ�¼�����е�ÿ���ַ�������ǵ���ĳ��������ȱ�ڡ��ٵ�������������¼��ֻ�����������ַ���
     * <p>
     * 'A'��Absent��ȱ��
     * 'L'��Late���ٵ�
     * 'P'��Present������
     * ���ѧ���ܹ� ͬʱ ����������������������Ի�ó��ڽ�����
     * <p>
     * �� �ܳ��� �ƣ�ѧ��ȱ�ڣ�'A'���ϸ� �������졣
     * ѧ�� ���� ���� ���� 3 ��� 3 �����ϵĳٵ���'L'����¼��
     * ���ѧ�����Ի�ó��ڽ��������� true �����򣬷��� false ��
     */

    /**
     * ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 36.5 MB , ������ Java �ύ�л����� 59.04% ���û�
     *
     * @param s
     * @return
     */
    public boolean checkRecord1(String s) {

        char[] chars = s.toCharArray();
        int A = 0;
        for (char ch : chars) {
            if (ch == 'A') {
                ++A;
            }
            if (A >= 2) {
                return false;
            }
        }
        return !s.contains("LLL");
    }

    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 36.3 MB , ������ Java �ύ�л����� 83.16% ���û�
    public boolean checkRecord(String s) {
        return (!s.contains("LLL"))&& (s.indexOf(65) == s.lastIndexOf(65));
    }
    public static void main(String[] args) {
        Test17 test17 = new Test17();
        Helper.print(test17.checkRecord("PPPLLA"));


    }
}

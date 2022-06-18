package com.king.year_2021.M10;

import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 869. ��������õ� 2 ����
 * https://leetcode-cn.com/problems/reordered-power-of-2/comments/
 * @author: King
 * @create: 2021-10-28 02:14
 */
public class Test28 {

    //���������� N?�����ǰ��κ�˳�򣨰���ԭʼ˳�򣩽�������������ע����ǰ�����ֲ���Ϊ�㡣
    //
    //������ǿ���ͨ��������ʽ�õ�?2 ���ݣ����� true�����򣬷��� false��

    //ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 97.93% ���û�
    //�ڴ����ģ� 35.2 MB , ������ Java �ύ�л����� 77.59% ���û�
    public boolean reorderedPowerOf2(int N) {
        String[] rec = {"1", "2", "4", "8", "16", "23", "46", "128", "256", "125", "0124", "0248", "0469", "1289", "13468",
                "23678", "35566", "011237", "122446", "224588", "0145678", "0122579", "0134449", "0368888",
                "11266777", "23334455", "01466788", "112234778", "234455668", "012356789", "0112344778"};
        char[] at = String.valueOf(N).toCharArray();
        Arrays.sort(at);
        String str = new String(at);
        for (String p : rec) {
            if (str.equals(p)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Test28 test28 = new Test28();
        //ʾ�� 4��
        //
        //���룺24
        //�����false
        //ʾ�� 5��
        //
        //���룺46
        //�����true
        MyPrint.print(test28.reorderedPowerOf2(24));
    }
}

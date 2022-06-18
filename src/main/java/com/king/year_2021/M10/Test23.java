package com.king.year_2021.M10;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 492. �������
 * https://leetcode-cn.com/problems/construct-the-rectangle/
 * @author: King
 * @create: 2021-10-23 23:11
 */
public class Test23 {

    //��Ϊһλweb�����ߣ� ��������ȥ�滮һ��ҳ��ĳߴ��Ǻ���Ҫ�ġ� �ָ���һ������ľ���ҳ�������
    // ������������һ������Ϊ L �Ϳ��Ϊ W ����������Ҫ��ľ��ε�ҳ�档Ҫ��
    //
    //1. ����Ƶľ���ҳ�������ڸ�����Ŀ�������
    //
    //2. ��� W ��Ӧ���ڳ��� L������֮��Ҫ�� L >= W ��
    //
    //3. ���� L �Ϳ�� W ֮��Ĳ��Ӧ��������С��

    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û�
    //�ڴ����ģ� 35.8 MB , ������ Java �ύ�л����� 59.59% ���û�
    public int[] constructRectangle1(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            --w;
        }
        return new int[]{area / w, w};
    }


    //�������⣬�� sqrt(area) ��ʼ����ģ�⣬������һ���ܹ�����������ֵ���򷵻ظô𰸡�
        public int[] constructRectangle(int area) {
            for (int i = (int)(Math.sqrt(area)); ;i--) {
                if (area % i == 0) return new int[]{area / i, i};
            }
        }


    public static void main(String[] args) {
        Test23 test33 = new Test23();
        MyPrint.print(test33.constructRectangle(11));
    }
}

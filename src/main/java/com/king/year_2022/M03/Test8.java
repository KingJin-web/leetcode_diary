package com.king.year_2022.M03;

import com.king.util.MyPrint;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @program: leetcode_diary
 * @description: 2055. ����֮�������
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/plates-between-candles
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2022-03-08 16:18
 */
public class Test8 {
    //����һ�������ӣ����������Ӻ������ų�һ�С�����һ���±�� 0��ʼ���ַ���s����ֻ�����ַ�'*' ��'|'������'*'��ʾһ�� ���ӣ�'|'��ʾһ֧����
    //
    //ͬʱ����һ���±�� 0��ʼ�Ķ�ά��������queries������queries[i] = [lefti, righti]��ʾ ���ַ���s[lefti...righti]���������Ҷ˵���ַ���������ÿ����ѯ������Ҫ�ҵ� ���ַ������� ��֧����֮������ӵ� ��Ŀ�����һ�������� ���ַ�������ߺ��ұ� ��������һ֧������ô������������� ��֧����֮�䡣
    //
    //�ȷ�˵��s = "||**||**|*"����ѯ[3, 8]����ʾ�������ַ���"*||**|"�����ַ���������֧����֮���������ĿΪ2�����ַ������ұ�����������������ߺ��ұ� �� ������һ֧����
    //���㷵��һ����������answer������answer[i]�ǵ�i����ѯ�Ĵ𰸡�
    //
    //
    //


    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] plateAndCandle = s.toCharArray();
        int strLen = s.length();

        // * ǰ׺��
        int[] prefixSum = new int[strLen + 1];
        prefixSum[0] = s.charAt(0) == '*' ? 1 : 0;
        for (int i = 1; i < plateAndCandle.length; i++) {
            if (plateAndCandle[i] == '*') {
                prefixSum[i] = prefixSum[i - 1] + 1;
            } else {
                prefixSum[i] = prefixSum[i - 1];
            }
        }
        System.out.println(Arrays.toString(prefixSum));


        // ��� i ����һ������λ��
        int[] leftCandlePos = new int[strLen];
        int lastPos = -1;
        for (int i = 0; i < plateAndCandle.length; i++) {
            if (plateAndCandle[i] == '|') {
                lastPos = i;
            }
            leftCandlePos[i] = lastPos;
        }
        System.out.println(Arrays.toString(leftCandlePos));


        lastPos = -1;
        // ��� i �Ҳ��һ������λ��
        int[] rightCandlePos = new int[strLen];
        for (int i = plateAndCandle.length - 1; i >= 0; i--) {
            if (plateAndCandle[i] == '|') {
                lastPos = i;
            }
            rightCandlePos[i] = lastPos;
        }
        System.out.println(Arrays.toString(rightCandlePos));


        int len = queries.length;
        int[] res = new int[len];

        int cnt = 0;
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];

            // <= �����Ϊ |**| �����
            if (rightCandlePos[start] == -1 || leftCandlePos[end] == -1 || leftCandlePos[end] <= rightCandlePos[start]) {
                res[cnt++] = 0;
            } else {
                res[cnt++] = prefixSum[leftCandlePos[end]] - prefixSum[rightCandlePos[start]];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        //���룺s = "**|**|***|", queries = [[2,5],[5,9]]
        //�����[2,3]
        //���ͣ�
        //- queries[0] ����������������֮�䡣
        //- queries[1] ����������������֮�䡣
        //
        //��Դ�����ۣ�LeetCode��
        //���ӣ�https://leetcode-cn.com/problems/plates-between-candles
        //����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������






        Test8 test8 = new Test8();
        MyPrint.print(test8.platesBetweenCandles("**|**|***|",new int[][]{{2,5},{5,9}}));
//        try(Scanner in = new Scanner(System.in)){
//            String[] strings = new String[3];
//            for (int i = 0; i < strings.length; i++) {
//                strings[i] = in.nextLine();
//            }
//            MyPrint.print(Arrays.toString(strings) +"���: "
//                    + Arrays.stream(strings).max(String::compareTo).get());
//        }

        //�ж϶Գ���
        StringBuilder sb1 = new StringBuilder("12329");
        StringBuilder sb2 = new StringBuilder("12329");
        sb1.reverse();
        System.out.println(sb1.toString().equals(sb2.toString()));


        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        System.out.println("������" + c.getActualMaximum(Calendar.DAY_OF_MONTH));

    }

}

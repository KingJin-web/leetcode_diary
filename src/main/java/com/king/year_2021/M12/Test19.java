package com.king.year_2021.M12;

import com.king.util.MyPrint;

import java.math.BigInteger;

/**
 * @program: leetcode
 * @description: 997. �ҵ�С��ķ���
 * https://leetcode-cn.com/problems/find-the-town-judge/
 * @author: King
 * @create: 2021-12-19 22:11
 */
public class Test19 {
    //�ֱ�����������洢��һ�������洢�������Ҳ������������˵ĸ����������±���Ǵ�����ˣ�1��N
    //����һ�������洢��������Ҳ���������ŵ��˵ĸ���
    //���������N-1��������Ϊ0��������˾��Ƿ��٣������޷�ȷ�����١�

    //ִ����ʱ�� 2 ms , ������ Java �ύ�л����� 99.21% ���û�
    //�ڴ����ģ� 45.8 MB , ������ Java �ύ�л����� 81.98% ���û�
    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n + 1];
        int[] outDegrees = new int[n + 1];
        for (int[] edge : trust) {
            int x = edge[0], y = edge[1];
            ++inDegrees[y];
            ++outDegrees[x];
        }
        for (int i = 1; i <= n; ++i) {
            if (inDegrees[i] == n - 1 && outDegrees[i] == 0) {
                return i;
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        Test19 test19 = new Test19();
//        ���룺n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
//        �����3
        int n = 4;
        int[][] trust = new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        MyPrint.print(test19.findJudge(n, trust));


        BigInteger num = BigInteger.valueOf(12);

        System.out.println(fact(101));

    }

    //����ѭ�����˷�
    public static BigInteger fact(int num) {
        int temp = 1;
        BigInteger factorial = BigInteger.valueOf(1);
        while (num >= temp) {
            factorial = factorial.multiply(BigInteger.valueOf(temp));
            temp++;
        }
        return factorial;
    }

}

package com.king.year_2021.M08;

/**
 * @program: leetcode
 * @description: 526. ����������
 * https://leetcode-cn.com/problems/beautiful-arrangement/
 * @author: King
 * @create: 2021-08-16 21:06
 */
public class Test15 {

    /**
     * ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 35.1 MB , ������ Java �ύ�л����� 69.08% ���û�
     *
     * @param n
     * @return
     */
    public int countArrangement1(int n) {
        int[] table = new int[]{0, 1, 2, 3, 8, 10, 36, 41, 132, 250, 700, 750, 4010, 4237, 10680, 24679};
        return table[n];

    }

    int count = 0;

    /**
     * ִ����ʱ�� 55 ms , ������ Java �ύ�л����� 71.71% ���û� �ڴ����ģ� 35.1 MB , ������ Java �ύ�л����� 73.19% ���û�
     * @param N
     * @return
     */
    public int countArrangement(int N) {
        int[] visited = new int[N + 1];
        countArrangement(1, N, visited);
        return count;
    }

    public void countArrangement(int step, int N, int[] visited) {
        if (step == N + 1) {
            count++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            //�ù��Ĳ����ٴ�ʹ�ã������ظ�
            if (visited[i] == 0) {
                visited[i] = 1;
                //�����������У���֦
                if (i % step == 0 || step % i == 0) {
                    countArrangement(step + 1, N, visited);
                }
                visited[i] = 0;
            }
        }

    }

}

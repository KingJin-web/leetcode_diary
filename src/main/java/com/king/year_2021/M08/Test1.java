package com.king.year_2021.M08;

import com.king.util.Helper;

import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-08-01 14:46
 */
public class Test1 {
    public static T1 t1 = new T1();


    /**
     * 1337. ������ս���������� K ��
     * https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
     */
    public static class T1 {

        // ���� + �����
        // ʱ�䣺O(M*logN + M*logK)
        // �ռ䣺O(M + K)
        public int[] kWeakestRows(int[][] mat, int k) {
            int m = mat.length;
            // 1��ͳ��ÿ�еľ�������������arr����
            int[][] arr = new int[m][2]; // arr[i][0]����i�еľ���������arr[i][1]���к�i
            for (int i = 0; i < m; i++) {
                int index = findTheMostRightOne(mat[i]); // ���ֲ���
                arr[i] = new int[]{index + 1, i};
            }
            // 2��ʹ������Ϊk�Ĵ���ѣ��Ѷ�ά��"�ż�"���������˺�ֻ��"�ɵ�"�ż����������
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>(((o1, o2) -> o2[0] != o1[0] ? o2[0] - o1[0] : o2[1] - o1[1]));
            for (int[] row : arr) {
                if (maxHeap.size() < k) maxHeap.add(row); // ����δ����ֱ�����
                else { // maxHeap.size() == k �����������
                    int[] peek = maxHeap.peek();

                    if (row[0] < peek[0] || (row[0] == peek[0] && row[1] < peek[1])) {
                        maxHeap.poll(); // �ɵ��ż�
                        maxHeap.add(row); // �������
                    }
                }
            }
            // 3���Ӵ�������ε���Ԫ�أ�������
            int[] ans = new int[k];
            while (k >= 1) {
                ans[--k] = maxHeap.poll()[1];
            }
            return ans;
        }

        // ���ֲ��ң��ҵ����Ҳ��1�����±귵�أ����û�У�����-1
        private int findTheMostRightOne(int[] arr) {
            int l = 0, r = arr.length - 1, index = -1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (arr[m] == 1) { // �ҵ���1����¼�´�ʱindex���ٿ��Ҳ��Ƿ��и��ҵ�
                    index = m;
                    l = m + 1;
                } else { // ������
                    r = m - 1;
                }
            }
            return index;
        }

        public static void main(String[] args) {
            int[][] a = new int[][]{
                    {1, 1, 0, 0, 0},
                    {1, 1, 1, 1, 0},
                    {1, 0, 0, 0, 0},
                    {1, 1, 0, 0, 0},
                    {1, 1, 1, 1, 1}};
            Helper.print(t1.kWeakestRows(a, 3));


        }
    }

    /**
     * 5830. ������
     */
    public static class T2{
        public static void main(String args[]) {
            int i = 0;
            i = i++ + i;
            System.out.println("I =" +i);
        }
    }
}

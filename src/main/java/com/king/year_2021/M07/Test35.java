package com.king.year_2021.M07;

import com.king.util.Helper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-07-31 09:38
 */
public class Test35 {
    static Test35 t35 = new Test35();
    static T1 t1 = new T1();

    /**
     * @program: leetcode
     * @description: ������ 01.08. �����
     * https://leetcode-cn.com/problems/zero-matrix-lcci/
     * @author: King
     * @create: 2021-07-31 09:38
     */
    public static class T1 {
        /**
         * ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û�
         * �ڴ����ģ� 40 MB , ������ Java �ύ�л����� 41.32% ���û�
         *
         * @param matrix
         */
        public void setZeroes(int[][] matrix) {
            int lenx = matrix.length, leny = matrix[0].length;
            boolean[] row = new boolean[lenx], col = new boolean[leny];
            for (int i = 0; i < lenx; ++i) {
                for (int j = 0; j < leny; ++j) {
                    if (matrix[i][j] == 0) {
                        row[i] = true;
                        col[j] = true;
                    }
                }
            }

            for (int i = 0; i < lenx; ++i) {
                for (int j = 0; j < leny; ++j) {
                    if (row[i] || col[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        public static void main(String[] args) {

            int[][] nums = new int[][]{
                    {1, 1, 1},
                    {1, 0, 1},
                    {1, 1, 1}
            };
            Helper.print(nums);
            t1.setZeroes(nums);
            Helper.print();
            Helper.print(nums);

        }
    }

    static T2 t2 = new T2();

    /**
     * @program: leetcode
     * @description: 720. �ʵ�����ĵ���
     * https://leetcode-cn.com/problems/longest-word-in-dictionary/
     * @author: King
     * @create: 2021-07-31 09:38
     */
    public static class T2 {
        public String longestWord(String[] words) {
            //����������������Set����ĸ�洢��С�ĵ���һ�������ں����ĵ������档����ֻ��Ҫȡǰ׺��ͬ��
            //����ĸ����󣬵�һ������һ���ǹ��еģ�����ֻ���ڴ˻��������
            Arrays.sort(words);

            Set<String> set = new HashSet<>();
            String res = "";
            for (String s : words) {
                //�������ֻ��һ����ĸ����һ���ǹ��е�
                if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                    res = s.length() > res.length() ? s : res;
                    set.add(s);
                }
            }
            return res;
        }

        public static void main(String[] args) {
            Helper.printf(t2.longestWord(
                    Helper.getArrays("a", "banana", "app", "appl", "ap", "apply", "apple"))
            );
        }
    }
}

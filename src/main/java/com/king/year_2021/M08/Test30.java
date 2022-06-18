package com.king.year_2021.M08;

import com.king.util.Helper;

import java.util.ArrayList;
import java.util.Random;

/**
 * @program: leetcode
 * @description: 528. ��Ȩ�����ѡ��
 * ���ӣ�https://leetcode-cn.com/problems/random-pick-with-weight
 * @author: King
 * @create: 2021-08-30 13:59
 */
public class Test30 {

    //ִ����ʱ�� 28 ms , ������ Java �ύ�л����� 62.44% ���û� �ڴ����ģ� 43.4 MB , ������ Java �ύ�л����� 33.78% ���û�
    public static class Solution {
        int[] pre;
        int sum = 0;

        public Solution(int[] w) {
            pre = new int[w.length];
            for (int i = 0; i < pre.length; i++) {
                sum += w[i];
                pre[i] = sum;
            }
        }

        static Random r = new Random();

        public int pickIndex() {
            int target = r.nextInt(sum) + 1;
            return getIdx(target);
        }

        public int getIdx(int target) {
            int l = 0, r = pre.length - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (pre[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }

    public static void main(String[] args) {
        //���룺
        //["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
        //[[[1,3]],[],[],[],[],[]]
        //�����
        //[null,1,1,1,1,0]
        //���ͣ�
        //Solution solution = new Solution([1, 3]);
        //solution.pickIndex(); // ���� 1�������±� 1�����ظ��±����Ϊ 3/4 ��
        //solution.pickIndex(); // ���� 1
        //solution.pickIndex(); // ���� 1
        //solution.pickIndex(); // ���� 1
        //solution.pickIndex(); // ���� 0�������±� 0�����ظ��±����Ϊ 1/4 ��
        //
        //��������һ��������⣬�������𰸣����������������Ա���Ϊ����ȷ��:
        //[null,1,1,1,1,0]
        //[null,1,1,1,1,1]
        //[null,1,1,1,0,0]
        //[null,1,1,1,0,1]
        //[null,1,0,1,0,0]
        //......
        //�������ࡣ

        Solution solution = new Solution(Helper.getArrays(1, 3));
        ArrayList<Integer> list = new ArrayList<>();

        list.add(solution.pickIndex()); // ���� 1�������±� 1�����ظ��±����Ϊ 3/4 ��
        list.add(solution.pickIndex()); // ���� 1
        list.add(solution.pickIndex()); // ���� 1
        list.add(solution.pickIndex()); // ���� 1
        list.add(solution.pickIndex()); // ���� 0�������±� 0�����ظ��±����Ϊ 1/4 ��
        Helper.print(list.toArray());
    }
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
}

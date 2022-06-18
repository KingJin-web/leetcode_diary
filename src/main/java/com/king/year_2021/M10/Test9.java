package com.king.year_2021.M10;

import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: leetcode
 * @description: 352.����������Ϊ������ཻ����
 * https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/
 * @author: King
 * @create: 2021-10-09 23:22
 */

public class Test9 {
    //ʵ�� SummaryRanges �ࣺ
    //
    //SummaryRanges() ʹ��һ������������ʼ������
    //void addNum(int val) ���������м������� val ��
    //int[][] getIntervals() �Բ��ཻ����?[starti, endi] ���б���ʽ���ض����������������ܽᡣ

    //ִ����ʱ�� 315 ms , ������ Java �ύ�л����� 5.60% ���û� �ڴ����ģ� 44.1 MB , ������ Java �ύ�л����� 24.80% ���û�
    private static class SummaryRanges {

        private final List<Integer> list;

        public SummaryRanges() {
            list = new ArrayList<>();
        }

        public void addNum(int val) {
            list.add(val);
        }

        public int[][] getIntervals() {
            if (list.size() == 1) {
                return new int[][]{{list.get(0), list.get(0)}};
            }
            Collections.sort(list);
            List<int[]> intevals = new ArrayList<>();
            int l = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) - list.get(i - 1) > 1) {
                    intevals.add(new int[]{l, list.get(i - 1)});
                    l = list.get(i);
                }
            }
            intevals.add(new int[]{l, list.get(list.size() - 1)});
            return intevals.toArray(new int[intevals.size()][]);
        }


    }

    public static void main(String[] args) {

        // Your SummaryRanges object will be instantiated and called as such:
        SummaryRanges obj = new SummaryRanges();
        obj.addNum(10);
        int[][] param_2 = obj.getIntervals();

        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);      // arr = [1]
        // ���� [[1, 1]]
        MyPrint.print(summaryRanges.getIntervals(),true);

        summaryRanges.addNum(3);      // arr = [1, 3]
        // ���� [[1, 1], [3, 3]]
        MyPrint.print(summaryRanges.getIntervals());
        summaryRanges.addNum(7);      // arr = [1, 3, 7]
        // ���� [[1, 1], [3, 3], [7, 7]]
        MyPrint.print(summaryRanges.getIntervals());
        summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
        // ���� [[1, 3], [7, 7]]
        MyPrint.print(summaryRanges.getIntervals());
        summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
        // ���� [[1, 3], [6, 7]]
        MyPrint.print(summaryRanges.getIntervals());
    }

    //���룺
    //["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
    //[[], [1], [], [3], [], [7], [], [2], [], [6], []]
    //�����
    //[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
    //
    //���ͣ�
    //SummaryRanges summaryRanges = new SummaryRanges();
    //summaryRanges.addNum(1);      // arr = [1]
    //summaryRanges.getIntervals(); // ���� [[1, 1]]
    //summaryRanges.addNum(3);      // arr = [1, 3]
    //summaryRanges.getIntervals(); // ���� [[1, 1], [3, 3]]
    //summaryRanges.addNum(7);      // arr = [1, 3, 7]
    //summaryRanges.getIntervals(); // ���� [[1, 1], [3, 3], [7, 7]]
    //summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
    //summaryRanges.getIntervals(); // ���� [[1, 3], [7, 7]]
    //summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
    //summaryRanges.getIntervals(); // ���� [[1, 3], [6, 7]]
    //
    //��Դ�����ۣ�LeetCode��
    //���ӣ�https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals
    //����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
}

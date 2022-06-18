package com.king.year_2021.M09;

import com.king.util.ListNode;
import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 725. �ָ�����
 * https://leetcode-cn.com/problems/split-linked-list-in-parts/
 * @author: King
 * @create: 2021-09-22 18:21
 */
public class Test22 {
    //����һ��ͷ���Ϊ head �ĵ������һ������ k ���������һ���㷨������ָ�Ϊ k �������Ĳ��֡�
    //
    //ÿ���ֵĳ���Ӧ�þ����ܵ���ȣ����������ֵĳ��Ȳ�಻�ܳ��� 1 ������ܻᵼ����Щ����Ϊ null ��
    //
    //�� k ������Ӧ�ð����������г��ֵ�˳�����У���������ǰ��Ĳ��ֵĳ���Ӧ�ô��ڻ�������ں���ĳ��ȡ�
    //
    //����һ�������� k ������ɵ����顣

    //1�����������ȡ���� length������ܲ��� ?����
    //2��length ���� k �õ�ÿ�������ƽ������ aveLength �� ���� remainder��remainder ��ֵ�����ж��ٸ�����Ϊ (aveLength + 1) ������������ǰ�档
    //    2.1���ٸ����Ӱ������һ�� 11 / 3 = 3 �� 2�� һ����3�Σ�ÿ��ƽ��3���ڵ㣬����ʣ����2���ڵ㣬ʣ�µ�2���ڵ㲻�ܶ�������ȫ����������������ȥ����ô���أ�
    //    2.2���������ⳤ��������ǰ�棬�̵������ź��棬����ֻ��ǰ�������������һ�˷ֵ�һ������Ľڵ㣬���һ�����γ��� 4 4 3 �Ľṹ��
    //3�����������¶��ͱȽϼ��ˣ�����ÿ��������Ӧ�õĳ���[4, 4, 3]ȥ�ضϸ���������
    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 38.7 MB , ������ Java �ύ�л����� 13.70% ���û�
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode listNode = head;
        int len = 0;
        while (listNode != null) {
            listNode = listNode.next;
            ++len;
        }
        int quotient = len / k, remainder = len % k;
        ListNode[] listNodes = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; ++i) {
            curr.println();
            listNodes[i] = curr;
            int partSize = quotient + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; ++j) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return listNodes;
    }

    public static void main(String[] args) {
        Test22 test22 = new Test22();
        ListNode listNode = LeetcodeUtil.stringToListNode("[1,2,3,4,5,6,7,8,9,10]");
        for (ListNode listNode1 : test22.splitListToParts(listNode, 3)) {
            listNode1.println();
        }
        listNode = LeetcodeUtil.stringToListNode("[1,2,3]");
//        for (ListNode listNode1 : test22.splitListToParts1(listNode, 5)) {
//           // listNode1.println();
//        }
        MyPrint.print(Arrays.toString(test22.splitListToParts1(listNode, 5)));
//        listNode = LeetcodeUtil.stringToListNode("[1,2,3,4,5,6,7,8,9,10]");
//        for (ListNode listNode1 : test22.splitListToParts1(listNode, 3)) {
//            listNode1.println();
//        }
    }

    public ListNode[] splitListToParts1(ListNode head, int k) {
        ListNode listNode = head;
        int len = 0;
        while (listNode != null) {
            listNode = listNode.next;
            ++len;
        }
        int quotient = len / k, remainder = len % k;
        ListNode[] listNodes = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; ++i) {
            listNodes[i] = curr;
            int partSize = quotient + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; ++j) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return listNodes;
    }

}

package com.king.year_2021.M11;

import com.king.util.ListNode;
import com.king.util.LeetcodeUtil;

/**
 * @program: leetcode
 * @description: 237. ɾ�������еĽڵ�
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @author: King
 * @create: 2021-11-02 02:45
 */
public class Test2 {

    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 37.8 MB ,
    //������ Java �ύ�л����� 54.53% ���û�
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        ListNode listNode = LeetcodeUtil.stringToListNode("[4,5,1,9]");
        LeetcodeUtil.prettyPrintLinkedList(listNode);
        test2.deleteNode(listNode);
        LeetcodeUtil.prettyPrintLinkedList(listNode);
    }
}

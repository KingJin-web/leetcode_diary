package com.king.year_2021.M10;

import com.king.util.TreeNode;
import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: leetcode
 * @description: 230. �����������е�KС��Ԫ��
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * @author: King
 * @create: 2021-10-17 17:10
 */
public class Test17 {

    //����һ�������������ĸ��ڵ� root ����һ������ k ���������һ���㷨�������е� k ����СԪ�أ��� 1 ��ʼ��������


    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }



    public static void main(String[] args) {
        //root = [3,1,4,null,2], k = 1
        Test17 test17 = new Test17();
       TreeNode treeNode =  LeetcodeUtil.stringToTreeNode("[3,1,4,null,2]");
        LeetcodeUtil.prettyPrintTree(treeNode);

        MyPrint.print(test17.kthSmallest(treeNode,1));
    }

}

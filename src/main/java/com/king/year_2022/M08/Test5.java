package com.king.year_2022.M08;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;
import com.king.util.TreeNode;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年08月05日 08:57
 * @description: 623. 在二叉树中增加一行
 */
public class Test5 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 0 || d == 1) {
            TreeNode t = new TreeNode(v);
            if (d == 1) t.left = root;
            else t.right = root;
            return t;
        }
        if (root != null && d > 1) {
            root.left = addOneRow(root.left, v, d > 2 ? d - 1 : 1);
            root.right = addOneRow(root.right, v, d > 2 ? d - 1 : 0);
        }
        return root;
    }

    public static void main(String[] args) {
        Test5 test5 = new Test5();
        TreeNode root =  LeetcodeUtil.stringToTreeNode("[1,2,3,4,5,6,7]");
        TreeNode result = test5.addOneRow(root, 1, 3);
        MyPrint.print(LeetcodeUtil.treeNodeToString(result));

        //输入: root = [4,2,6,3,1,5], val = 1, depth = 2
        //输出: [4,1,1,2,null,null,6,3,1,5]
        TreeNode root2 =  LeetcodeUtil.stringToTreeNode("[4,2,6,3,1,5]");
        TreeNode result2 = test5.addOneRow(root2, 1, 2);
        MyPrint.print(LeetcodeUtil.treeNodeToString(result2));
    }
}
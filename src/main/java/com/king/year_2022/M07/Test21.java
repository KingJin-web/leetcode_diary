package com.king.year_2022.M07;

import com.king.util.LeetcodeUtil;
import com.king.util.TreeNode;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月21日 23:37
 * @description: 814. 二叉树剪枝
 */
public class Test21 {

    public TreeNode pruneTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }


    public static void main(String[] args) {
        Test21 test21 = new Test21();
        TreeNode root = LeetcodeUtil.stringToTreeNode("[1,null,0,0,1]");

        //输入：root = [1,null,0,0,1]
        //输出：[1,null,0,null,1]
        TreeNode result = test21.pruneTree(root);
        System.out.println(LeetcodeUtil.treeNodeToString(result));


        TreeNode root2 = LeetcodeUtil.stringToTreeNode("[1,0,1,0,0,0,1]");
        //输入：root = [1,0,1,0,0,0,1]
        //输出：[1,null,1,null,1]
        TreeNode result2 = test21.pruneTree(root2);
        System.out.println(LeetcodeUtil.treeNodeToString(result2));

    }

}
package com.king.year_2022.M05;

import com.king.util.TreeNode;

/**
 * @author: 12613
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M05.Test24
 * @date: 2022年05月24日 23:09
 * @description: 965. 单值二叉树
 */
public class Test24 {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val != root.val) {
            return false;
        }
        if (root.right != null && root.right.val != root.val) {
            return false;
        }
        return isUnivalTree(root.right) && isUnivalTree(root.left);
    }

    public static void main(String[] args) {

    }
}
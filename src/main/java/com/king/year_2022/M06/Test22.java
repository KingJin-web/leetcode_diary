package com.king.year_2022.M06;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;
import com.king.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年06月22日 03:08
 * @description: 513. 找树左下角的值
 * <a href="https://leetcode.cn/problems/find-bottom-left-tree-value/">513. 找树左下角的值</a>
 */
public class Test22 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    private static class Solution {
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                root = queue.poll();
                if (root.right != null) queue.offer(root.right);
                if (root.left != null) queue.offer(root.left);
            }
            return root.val;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        MyPrint.print(solution.findBottomLeftValue(LeetcodeUtil.stringToTreeNode("[1,2,3,4,null,5,6,null,null,7]")));
    }
}
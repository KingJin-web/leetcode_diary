package com.king.year_2022.M06;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;
import com.king.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年06月24日 22:59
 * @description: 515. 在每个树行中找最大值
 */
public class Test24 {
    //515. 在每个树行中找最大值
//    public int largestValues(TreeNode root) {
//        if (root == null) return 0;
//        int max = 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            int maxValue = Integer.MIN_VALUE;
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                maxValue = Math.max(maxValue, node.val);
//                if (node.left != null) queue.offer(node.left);
//                if (node.right != null) queue.offer(node.right);
//            }
//            max = Math.max(max, maxValue);
//        }
//        return max;
//    }
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    public void dfs(List<Integer> res, TreeNode root, int curHeight) {
        if (curHeight == res.size()) {
            res.add(root.val);
        } else {
            res.set(curHeight, Math.max(res.get(curHeight), root.val));
        }
        if (root.left != null) {
            dfs(res, root.left, curHeight + 1);
        }
        if (root.right != null) {
            dfs(res, root.right, curHeight + 1);
        }
    }

    public static void main(String[] args) {
        Test24 test24 = new Test24();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        MyPrint.print(test24.largestValues(root));


        TreeNode root1 = LeetcodeUtil.stringToTreeNode("[1,3,2,5,3,null,9]");
        MyPrint.print(test24.largestValues(root1));
    }
}
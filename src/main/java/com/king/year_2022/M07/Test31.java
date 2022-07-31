package com.king.year_2022.M07;


import com.king.util.LeetcodeUtil;
import com.king.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月31日 23:41
 * @description: 1161. 最大层内元素和
 */
public class Test31 {
    public int maxLevelSum(TreeNode root) {
        //用于维护层序之和，以及层序序号
        int[] res = new int[]{Integer.MIN_VALUE, 1};
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;
        queue.offer(root);
        int num = 1;
        while (!queue.isEmpty()) {
            int sum = 0;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode tmp = queue.poll();
                sum += tmp.val;
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
            }
            if (res[0] < sum) {
                res[0] = sum;
                res[1] = num;
            }
            num++;
        }
        return res[1];
    }



    public static void main(String[] args) {
        Test31 test31 = new Test31();
        TreeNode root = LeetcodeUtil.stringToTreeNode("[-1,null,-2,-3,null,null,-4]");
        System.out.println(test31.maxLevelSum(root));
    }
}


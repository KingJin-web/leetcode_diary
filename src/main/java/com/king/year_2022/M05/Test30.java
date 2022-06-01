package com.king.year_2022.M05;

import com.king.util.Helper;
import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;
import com.king.util.TreeNode;
/**
 * @author: 12613
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M05.Test30
 * @date: 2022年05月30日 23:35
 * @description: 1022. 从根到叶的二进制数之和
 */
public class Test30 {
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int sum){
        if(root == null) return 0;
        sum = 2 *sum + root.val;
        if(root.left == null && root.right == null){
            return sum;
        }

        return helper(root.left, sum) + helper(root.right, sum);
    }


    public static void main(String[] args) {
       TreeNode treeNode = LeetcodeUtil.stringToTreeNode("[1,0,1,0,1,0,1]");
        MyPrint.print(treeNode);
    }
}
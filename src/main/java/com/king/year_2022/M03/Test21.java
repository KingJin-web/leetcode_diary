package com.king.year_2022.M03;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;
import com.king.util.TreeNode;


import java.util.HashSet;

/**
 * @program: leetcode_diary
 * @description: 653. 两数之和 IV - 输入 BST
 * @author: King
 * @create: 2022-03-21 23:35
 */
public class Test21 {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hashset = new HashSet<Integer>();
        return preOrder(root,hashset,k);
    }
    public boolean preOrder(TreeNode root,HashSet<Integer> hashset,int k){
        if(root == null)
            return false;
        if(hashset.contains(k - root.val)){
            return true;
        }
        hashset.add(root.val);
        return preOrder(root.left,hashset,k) || preOrder(root.right,hashset,k);
    }

    public static void main(String[] args) {

        //输入: root = [5,3,6,2,4,null,7], k = 9
        //输出: true
        Test21 test21 = new Test21();
        MyPrint.print(test21.findTarget(LeetcodeUtil.stringToTreeNode("[5,3,6,2,4,null,7]"),9));
    }
}

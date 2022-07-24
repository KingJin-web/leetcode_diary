package com.king.year_2022.M07;

import com.king.util.LeetcodeUtil;
import com.king.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月25日 01:53
 * @description: \
 */
public class Test25 {
   private static class  CBTInserter {

       Queue<TreeNode> candidate;
       TreeNode root;

       public CBTInserter(TreeNode root) {
           this.candidate = new ArrayDeque<TreeNode>();
           this.root = root;

           Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
           queue.offer(root);

           while (!queue.isEmpty()) {
               TreeNode node = queue.poll();
               if (node.left != null) {
                   queue.offer(node.left);
               }
               if (node.right != null) {
                   queue.offer(node.right);
               }
               if (!(node.left != null && node.right != null)) {
                   candidate.offer(node);
               }
           }
       }

       public int insert(int val) {
           TreeNode child = new TreeNode(val);
           TreeNode node = candidate.peek();
           int ret = node.val;
           if (node.left == null) {
               node.left = child;
           } else {
               node.right = child;
               candidate.poll();
           }
           candidate.offer(child);
           return ret;
       }

       public TreeNode get_root() {
           return root;
       }


    }

    public static void main(String[] args) {



        //输入
        //["CBTInserter", "insert", "insert", "get_root"]
        //[[[1, 2]], [3], [4], []]
        //输出
        //[null, 1, 2, [1, 2, 3, 4]]
        //
        //解释
        //CBTInserter cBTInserter = new CBTInserter([1, 2]);
        //cBTInserter.insert(3);  // 返回 1
        //cBTInserter.insert(4);  // 返回 2
        //cBTInserter.get_root(); // 返回 [1, 2, 3, 4]
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode.cn/problems/complete-binary-tree-inserter
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        Test25.CBTInserter cBTInserter = new Test25.CBTInserter(LeetcodeUtil.stringToTreeNode("[1,2]"));
        System.out.println(cBTInserter.insert(3));
        System.out.println(cBTInserter.insert(4));
        System.out.println(LeetcodeUtil.treeNodeToString(cBTInserter.get_root()));
    }
}
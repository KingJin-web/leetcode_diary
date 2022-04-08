package com.king.year_2022.M04;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode_diary
 * @description: 429. N 叉树的层序遍历
 * @author: King
 * @create: 2022-04-08 23:37
 */
public class Test8 {
    /*
// Definition for a Node.

*/
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

        public List<List<Integer>> levelOrder(Node root) {
            if (root == null) {
                return new ArrayList<List<Integer>>();
            }

            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            Queue<Node> queue = new ArrayDeque<Node>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int cnt = queue.size();
                List<Integer> level = new ArrayList<Integer>();
                for (int i = 0; i < cnt; ++i) {
                    Node cur = queue.poll();
                    level.add(cur.val);
                    for (Node child : cur.children) {
                        queue.offer(child);
                    }
                }
                ans.add(level);
            }

            return ans;
        }

}

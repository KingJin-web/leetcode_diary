package com.king.year_2022.M03;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode_diary
 * @description: 589. N 叉树的前序遍历
 * @author: King
 * @create: 2022-03-10 23:52
 */
public class Test10 {

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> preorder(Node root) {
        //递归版

        if (root == null)
            return res;
        res.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }

        return res;
    }
}

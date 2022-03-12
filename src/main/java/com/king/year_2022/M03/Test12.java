package com.king.year_2022.M03;


import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import static com.king.year_2022.M03.Test10.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode_diary
 * @description: 590. N 叉树的后序遍历
 * @author: King
 * @create: 2022-03-12 23:08
 */
public class Test12 {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;

        LinkedList<Node> l = new LinkedList<>();
        l.add(root);

        while (!l.isEmpty()) {
            Node t = l.pollLast();
            for (Node n : t.children) l.addLast(n);
            res.addFirst(t.val);
        }

        return res;
    }

    public static void main(String[] args) {
        Test12 test12 = new Test12();
        Node node = new Node();
        MyPrint.print(test12.postorder(node));
    }
}

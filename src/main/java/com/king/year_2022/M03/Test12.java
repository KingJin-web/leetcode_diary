package com.king.year_2022.M03;


import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import static com.king.year_2022.M03.Test10.Node;

import java.util.Arrays;
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

    public int test(int[] nums, int num) {
        //根据弃九法，所有加数的各位数字总和与求得总和的各位数字之和应该差9的整数倍
//        int sum = 0;
//        while (num != 0) {
//            sum += num % 10;
//            num = num / 10;
//        }

//
//        return 9 - sum;
//        int n = Arrays.stream(nums).sum();
//
//        while (n - sum > 10) {
//            sum += 9;
//        }
//        return n - sum;
        int n = 0; //数组和
        for (int i : nums) {
            n += i;
        }
        n = n % 9 == 0 ? 9 : n % 9;
        return n - ((num - 1) % 9 + 1);
    }

    public static void main(String[] args) {
        Test12 test12 = new Test12();
        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(test12.test(nums, 3102));
        System.out.println(test12.test(nums, 2010)); //6
        System.out.println(test12.test(nums, 4321)); //8
        Node node = new Node();
        // MyPrint.print(test12.postorder(node));
    }
}

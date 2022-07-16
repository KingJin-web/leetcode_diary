package com.king.year_2022.M07;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月15日 23:27
 * @description: 558. 四叉树交集
 */
public class Test15 {
    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };

    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) {
            return quadTree1.val ? quadTree1 : quadTree2;
        }
        if (quadTree2.isLeaf) {
            return quadTree2.val ? quadTree2 : quadTree1;
        }
        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true, null, null, null, null);
        }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);

    }

    public static void main(String[] args) {
        Test15 test15 = new Test15();
        Node quadTree1 = new Node(true, true, null, null, null, null);
        Node quadTree2 = new Node(true, true, null, null, null, null);
        Node result = test15.intersect(quadTree1, quadTree2);
        System.out.println(result.val);


        LocalDate localDate = LocalDate.of(2022, 7, 15);
        LocalDate localDate1 = LocalDate.of(2022, 1, 1);

        //差值
        long between = localDate.toEpochDay() - localDate1.toEpochDay();
        System.out.println(between);
    }
}
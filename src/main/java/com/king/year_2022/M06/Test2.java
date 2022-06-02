package com.king.year_2022.M06;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;
import com.king.util.TreeNode;

/**
 * @author: 12613
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M06.Test2
 * @date: 2022年06月02日 23:52
 * @description: ${}
 */
public class Test2 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            // 待删除节点在左子树中
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            // 待删除节点在右子树中
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            // key == root.val，root 为待删除节点
            if (root.left == null) {
                // 返回右子树作为新的根
                return root.right;
            } else if (root.right == null) {
                // 返回左子树作为新的根
                return root.left;
            } else {
                // 左右子树都存在，返回后继节点（右子树最左叶子）作为新的根
                TreeNode successor = min(root.right);
                successor.right = deleteMin(root.right);
                successor.left = root.left;
                return successor;
            }
        }
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        TreeNode treeNode = test2.deleteNode(LeetcodeUtil.stringToTreeNode("[5,3,6,2,4,null,7]"), 3);
        MyPrint.print(treeNode.toString());
//        输入：root = [5,3,6,2,4,null,7], key = 3
//        输出：[5,4,6,2,null,null,7]
//        解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//        一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//        另一个正确答案是 [5,2,6,null,4,null,7]。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/delete-node-in-a-bst
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    }
}
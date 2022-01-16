package com.king.year_2022.M01;

import com.king.util.Helper;
import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: leetcode_diary
 * @description: 373. 查找和最小的 K 对数字
 * https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 * @author: King
 * @create: 2022-01-14 21:01
 */
public class Test14 {
    //执行用时： 6 ms , 在所有 Java 提交中击败了 97.20% 的用户 内存消耗： 49.7 MB , 在所有 Java 提交中击败了 57.72% 的用户
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2)->{
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i,0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idxPair = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[idxPair[0]]);
            list.add(nums2[idxPair[1]]);
            ans.add(list);
            if (idxPair[1] + 1 < n) {
                pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Test14 test14 = Helper.getYoursObj(Test14.class);
        //输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
        //输出: [1,2],[1,4],[1,6]
        //解释: 返回序列中的前 3 对数：
        //     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
        MyPrint.print(test14.kSmallestPairs(
                LeetcodeUtil.stringToIntegerArray("[1,7,11]"),
                LeetcodeUtil.stringToIntegerArray("[2,4,6]"),
                3));

       String s = (String) JOptionPane.showInputDialog(null,

                "请输入你的选择：", "选择",

                JOptionPane.WARNING_MESSAGE, null, new String[]{"A","B","C"}, "A");



    }

    }




package com.king.year_2022.M01;

import cn.hutool.http.Header;
import com.king.util.Helper;
import com.king.util.ListNode;

import java.util.Random;

/**
 * @program: leetcode_diary
 * @description: 382. 链表随机节点
 * https://leetcode-cn.com/problems/linked-list-random-node/
 * @author: King
 * @create: 2022-01-16 10:02
 */
public class Test16 {
    private static class Solution {
        private ListNode head;

        public Solution(ListNode head) {
            this.head = head;
        }

        public int getRandom() {
            int res = head.val;
            ListNode no = head.next;
            int i = 2;
            Random random = new Random();
            while (no != null) {
                if (random.nextInt(i) == 0) {
                    res = no.val;
                }
                i++;
                no = no.next;
            }
            return res;
        }
    }

    public static void main(String[] args) {
      Solution solution = Helper.getYoursObj(Solution.class);

    }
}

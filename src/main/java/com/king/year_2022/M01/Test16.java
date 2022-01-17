package com.king.year_2022.M01;

import com.king.util.LeetcodeUtil;
import com.king.util.ListNode;
import com.king.util.MyPrint;

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

  private static class Solution2 {
        ListNode head;
        Random random;
        public Solution2(ListNode head) {
            this.head=head;
            this.random=new Random();
        }

        public int getRandom() {
            // 蓄水池算法
            // 第一次拿第一个数 第一个数的概率是100%
            // 第二次 拿第二个数 取第二个数的概率是50%
            // 第三次 拿第三个数是 33% 则保留原本数的概率是66%
            ListNode p=this.head;
            int count=0;
            int res=0;
            while(p!=null){
                count++;
                int randomint=random.nextInt(count)+1;//因为生成的是[0，count)的值 而不包含count  所以要加1
                if(randomint==count){
                    res=p.val;
                }
                p=p.next;
            }
            return res;
        }
    }
    public static void main(String[] args) {

      ListNode listNode = LeetcodeUtil.stringToListNode("[1, 2, 3]");
        Solution solution = new Solution(listNode);
        MyPrint.print(solution.getRandom());
        MyPrint.print(solution.getRandom());
        MyPrint.print(solution.getRandom());

    }
}

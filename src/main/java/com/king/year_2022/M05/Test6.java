package com.king.year_2022.M05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author: King
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M05.Test6
 * @date: 2022年05月06日 23:39
 * @description: 933. 最近的请求次数
 */
public class Test6 {
    private static class RecentCounter1 {

        List<Integer> list;

        public RecentCounter1() {
            list = new ArrayList<>();
        }

        public int ping(int t) {
            //t-3000, t
            list.add(t);
            int i = 0;
            while (i < list.size() && list.get(i) < t - 3000) {
                i++;
            }
            return list.size() - i;
        }
    }

    private static class RecentCounter {

        Queue<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<Integer>();
        }

        public int ping(int t) {
            queue.offer(t);
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }
    public static void main(String[] args) {
        RecentCounter1 recentCounter = new RecentCounter1();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}
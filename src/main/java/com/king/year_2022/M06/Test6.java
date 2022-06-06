package com.king.year_2022.M06;

import java.util.TreeMap;

/**
 * @author: 12613
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M06.Test6
 * @date: 2022年06月06日 23:34
 * @description: ${}
 */
public class Test6 {
   private static class MyCalendarThree {

        private TreeMap<Integer, Integer> calendar;

        public MyCalendarThree() {
            calendar = new TreeMap<>();
        }

        public int book(int start, int end) {

            // 添加至日程中
            calendar.put(start, calendar.getOrDefault(start, 0) + 1);
            calendar.put(end, calendar.getOrDefault(end, 0) - 1);

            // 记录最大活跃的日程数
            int max = 0;
            // 记录活跃的日程数
            int active = 0;

            for (Integer d : calendar.values()) {
                // 以时间线统计日程
                active += d;

                // 找到活跃事件数量最多的时刻，记录下来。
                if (active > max) {
                    max = active;
                }
            }

            return max;
        }

    }
}
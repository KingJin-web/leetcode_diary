package com.king.year_2022.M06;

import com.king.util.MyPrint;

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

        private final TreeMap<Integer, Integer> calendar;

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

    public static void main(String[] args) {
        MyCalendarThree obj = new MyCalendarThree();
        //["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
        //[[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode.cn/problems/my-calendar-iii
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        int param_1 = obj.book(10, 20);
        int param_2 = obj.book(50, 60);
        int param_3 = obj.book(10, 40);
        int param_4 = obj.book(5, 15);
        int param_5 = obj.book(5, 10);
        int param_6 = obj.book(25, 55);
        MyPrint.printObs(param_1, param_2, param_3, param_4, param_5, param_6);
    }
}
package com.king.year_2022.M07;

import java.util.TreeMap;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月05日 23:38
 * @description: 729. 我的日程安排表 I
 */
public class Test5 {

    private static class MyCalendar {

        TreeMap<Integer, Integer> map;

        public MyCalendar() {
            map = new TreeMap<>();
            map.put(-1, -1);
            map.put((int) 1e9 + 1, (int) 1e9 + 1);
        }

        public boolean book(int start, int end) {
            Integer a = map.ceilingKey(start);//右边
            Integer b = map.floorKey(start);//左边
            if (a < end || map.get(b) > start) {
                return false;
            }
            map.put(start, end);
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // returns true
        System.out.println(myCalendar.book(15, 25)); // returns false
        System.out.println(myCalendar.book(20, 30)); // returns true

    }
}
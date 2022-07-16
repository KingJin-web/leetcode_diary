package com.king.year_2022.M07;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月16日 23:26
 * @description: 剑指 Offer II 041. 滑动窗口的平均值
 */
public class Test16 {
    private class MovingAverage {


        private int size;
        private int sum;
        private int index;
        private int[] queue;
        public MovingAverage(int size) {
            this.size = size;
            this.queue = new int[size];
        }

        public double next(int val) {
            if (index == size) {
                sum -= queue[index % size];
            }
            sum += val;
            queue[index++ % size] = val;
            return (double) sum / index;
        }
    }

    public static void main(String[] args) {
        Test16 test16 = new Test16();

        Test16.MovingAverage movingAverage = test16.new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(2));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(4));
        System.out.println(movingAverage.next(5));
    }
}
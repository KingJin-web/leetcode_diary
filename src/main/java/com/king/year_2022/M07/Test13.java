package com.king.year_2022.M07;

import com.king.util.MyPrint;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月13日 23:39
 * @description:
 */
public class Test13 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int aster : asteroids) {
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -aster; // aster 是否存在
                if (stack.peek() <= -aster) {  // 栈顶行星爆炸
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(aster);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Test13 test13 = new Test13();
        int[] asteroids = {-2, -1, 1, 2};
        int[] ans = test13.asteroidCollision(asteroids);
        MyPrint.print(ans);
    }
}
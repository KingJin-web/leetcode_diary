package com.king.year_2022.M02;

import com.king.util.MyPrint;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode_diary
 * @description: 1189. “气球” 的最大数量
 * @author: King
 * @create: 2022-02-13 23:19
 */
public class Test13 {
    //给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
    //
    //字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 11.24% 的用户
     * @param text
     * @return
     */
    public int maxNumberOfBalloons(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        for (char c : text.toCharArray()) {
            switch (c) {
                case 'b':
                    ++b;
                    break;
                case 'a':
                    ++a;
                    break;
                case 'l':
                    ++l;
                    break;
                case 'o':
                    ++o;
                    break;
                case 'n':
                    ++n;
                    break;
                default:
                    break;
            }
        }
        return min(b, min(a, min(n, min(l / 2, o / 2))));
    }

    private int min(int a, int b) {
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        Test13 test13 = new Test13();
        MyPrint.printObs(test13.maxNumberOfBalloons("loonbalxballpoon"));
    }
}

package com.king.year_2022.M01;

import java.util.*;

/**
 * @program: leetcode_diary
 * @description: 884. 两句话中的不常见单词
 * @author: King
 * @create: 2022-01-30 22:13
 */
public class Test30 {

    //执行用时： 5 ms , 在所有 Java 提交中击败了 21.26% 的用户 内存消耗： 41.1 MB , 在所有 Java 提交中击败了 5.06% 的用户
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] strs = (s1 + " " + s2).split(" ");
        Map<String, Integer> sim = new HashMap<>();
        for (String s : strs) {
            sim.put(s, sim.getOrDefault(s, 0) + 1);
        }
        //3.如果出现的次数为1，就是唯一的不常见单词
        List<String> list = new ArrayList<>();
        for (String key : sim.keySet()) {
            if (sim.get(key) == 1) {
                list.add(key);
            }
        }

        return list.toArray(new String[0]);
    }
}

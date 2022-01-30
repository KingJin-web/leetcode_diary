package com.king.year_2022.M01;

import com.king.util.MyPrint;

import java.util.*;

/**
 * @program: leetcode_diary
 * @description: 884. 两句话中的不常见单词
 * https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/
 * @author: King
 * @create: 2022-01-30 22:13
 */
public class Test30 {
    //句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
    //
    //如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
    //
    //给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。

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

    public static void main(String[] args) {
        Test30 test30 = new Test30();
        //输入：s1 = "this apple is sweet", s2 = "this apple is sour"
        //输出：["sweet","sour"]
        Object o = test30.uncommonFromSentences( "this apple is sweet",  "this apple is sour");
        MyPrint.printObs(o);
    }
}

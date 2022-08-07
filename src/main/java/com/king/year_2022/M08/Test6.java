package com.king.year_2022.M08;

import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年08月06日 23:48
 * @description: 1408. 数组中的字符串匹配
 */
public class Test6 {
    //暴力
    public List<String> stringMatching1(String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            for (String s : words) {
                if (word.length() >= s.length()) continue;
                if (s.contains(word)) {
                    res.add(word);
                    break;
                }
            }
        }
        return res;
    }

    //先把所有的word连在一起，用分隔符分开，然后每一个word在长word中搜索两次后，仍能匹配成功，说明这个word必然是满足题意的。
    //执行用时： 2 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 41 MB , 在所有 Java 提交中击败了 51.46% 的用户
    public List<String> stringMatching(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            sb.append("|");
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (sb.indexOf(word) != sb.lastIndexOf(word)) {
                res.add(word);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Test6 test6 = new Test6();
        String[] words = {"mass", "as", "hero", "superhero"};
        List<String> res = test6.stringMatching(words);
        MyPrint.print(res);
    }

}
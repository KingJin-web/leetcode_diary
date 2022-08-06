package com.king.year_2022.M08;

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
    public List<String> stringMatching(String[] words) {
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

}
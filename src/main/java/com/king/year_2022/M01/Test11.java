package com.king.year_2022.M01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode_diary
 * @description: 1408. 数组中的字符串匹配
 * https://leetcode-cn.com/problems/string-matching-in-an-array/
 * @author: King
 * @create: 2022-01-11 23:44
 */
public class Test11 {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words,(a, b)->a.length() - b.length());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if(words[j].contains(words[i])&&!list.contains(words[i])){
                    list.add(words[i]);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}

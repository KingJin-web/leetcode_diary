package com.king.year_2022.M06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 12613
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M06.Test12
 * @date: 2022年06月12日 23:49
 * @description: ${}
 */
public class Test12 {

    class Solution {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> ans = new ArrayList<String>();
            for (String word : words) {
                if (match(word, pattern) && match(pattern, word)) {
                    ans.add(word);
                }
            }
            return ans;
        }

        public boolean match(String word, String pattern) {
            Map<Character, Character> map = new HashMap<Character, Character>();
            for (int i = 0; i < word.length(); ++i) {
                char x = word.charAt(i), y = pattern.charAt(i);
                if (!map.containsKey(x)) {
                    map.put(x, y);
                } else if (map.get(x) != y) { // word 中的同一字母必须映射到 pattern 中的同一字母上
                    return false;
                }
            }
            return true;
        }
    }

}
package com.king.year_2022.M06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年06月23日 23:26
 * @description:
 */
public class Test23 {
   private static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<Integer>();
            int m = words.length, n = words[0].length(), ls = s.length();
            for (int i = 0; i < n; i++) {
                if (i + m * n > ls) {
                    break;
                }
                Map<String, Integer> differ = new HashMap<String, Integer>();
                for (int j = 0; j < m; j++) {
                    String word = s.substring(i + j * n, i + (j + 1) * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                }
                for (String word : words) {
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                for (int start = i; start < ls - m * n + 1; start += n) {
                    if (start != i) {
                        String word = s.substring(start + (m - 1) * n, start + m * n);
                        differ.put(word, differ.getOrDefault(word, 0) + 1);
                        if (differ.get(word) == 0) {
                            differ.remove(word);
                        }
                        word = s.substring(start - n, start);
                        differ.put(word, differ.getOrDefault(word, 0) - 1);
                        if (differ.get(word) == 0) {
                            differ.remove(word);
                        }
                    }
                    if (differ.isEmpty()) {
                        res.add(start);
                    }
                }
            }
            return res;
        }
    }

}
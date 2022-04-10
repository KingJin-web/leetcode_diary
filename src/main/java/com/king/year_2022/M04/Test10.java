package com.king.year_2022.M04;

import java.util.HashSet;

/**
 * @program: leetcode_diary
 * @description: 804. 唯一摩尔斯密码词
 * @author: King
 * @create: 2022-04-10 23:51
 */
public class Test10 {
    private static String[] map = {
            ".-",
            "-...",
            "-.-.",
            "-..",
            ".",
            "..-.",
            "--.",
            "....",
            "..",
            ".---",
            "-.-",
            ".-..",
            "--",
            "-.",
            "---",
            ".--.",
            "--.-",
            ".-.",
            "...",
            "-",
            "..-",
            "...-",
            ".--",
            "-..-",
            "-.--",
            "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        if (words == null) return 0;
        HashSet<String> set = new HashSet<String>();
        for (String s : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(map[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

}

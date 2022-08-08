package com.king.year_2022.M08;

import java.util.*;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年08月08日 22:41
 * @description: 761. 特殊的二进制序列
 */
public class Test8 {
    public String makeLargestSpecial(String s) {
        int count = 0, pre = 0, n = s.length();
        if (n == 0) {
            return "";
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '1') {
                count++;
            } else {
                count--;
                if (count == 0) {
                    list.add("1" + makeLargestSpecial(s.substring(pre + 1, i)) + "0");
                    pre = i + 1;
                }
            }
        }
        Collections.sort(list);
        String ans = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            ans += list.get(i);
        }
        return ans;
    }
}
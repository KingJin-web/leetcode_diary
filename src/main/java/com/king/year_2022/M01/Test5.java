package com.king.year_2022.M01;

/**
 * @program: leetcode_diary
 * @description: 1576. 替换所有的问号
 * @author: King
 * @create: 2022-01-05 00:03
 */
public class Test5 {
    //执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 75.00% 的用户
    public String modifyString(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '?') {
                char m = 0, n = 0;
                char a = 'a';
                if (i != 0) m = c[i - 1];
                if (i != c.length - 1) n = c[i + 1];
                while (a == m || a == n) a++;
                c[i] = a;
            }
        }
        return new String(c);
    }
}

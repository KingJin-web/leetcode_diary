package com.king.year_2022.M04;

/**
 * @program: leetcode_diary
 * @description: 806. 写字符串需要的行数
 * @author: King
 * @create: 2022-04-12 22:29
 */
public class Test12 {
        public static final int MAX_WIDTH = 100;

        public int[] numberOfLines(int[] widths, String s) {
            int lines = 1;
            int width = 0;
            for (int i = 0; i < s.length(); i++) {
                int need = widths[s.charAt(i) - 'a'];
                width += need;
                if (width > MAX_WIDTH) {
                    lines++;
                    width = need;
                }
            }
            return new int[]{lines, width};
        }


}

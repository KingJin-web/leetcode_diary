package com.king.year_2022.M07;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月14日 23:23
 * @description: 745. 前缀和后缀搜索
 */
public class Test14 {
    private static class WordFilter {

        String words[];

        public WordFilter(String[] words) {
            this.words = words;
        }

        public int f(String pref, String suff) {
            for (int i = words.length - 1; i >= 0; i--) {
                if (words[i].startsWith(pref) && words[i].endsWith(suff)) {
                    return i;
                }
            }
            return -1;
        }
    }

    /**
     * Your WordFilter object will be instantiated and called as such:
     * WordFilter obj = new WordFilter(words);
     * int param_1 = obj.f(pref,suff);
     */

    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"apple", "app"});
        System.out.println(wordFilter.f("a", "e"));
    }
}
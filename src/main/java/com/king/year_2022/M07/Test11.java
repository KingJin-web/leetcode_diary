package com.king.year_2022.M07;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月11日 23:08
 * @description:
 */
public class Test11 {
   private static class MagicDictionary {
        private String[] words;

        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            words = dictionary;
        }

        public boolean search(String searchWord) {
            for (String word : words) {
                if (word.length() != searchWord.length()) {
                    continue;
                }

                int diff = 0;
                for (int i = 0; i < word.length(); ++i) {
                    if (word.charAt(i) != searchWord.charAt(i)) {
                        ++diff;
                        if (diff > 1) {
                            break;
                        }
                    }
                }
                if (diff == 1) {
                    return true;
                }
            }
            return false;
        }
    }


    public void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode", "world", "word", "helloworld"});
        System.out.println(magicDictionary.search("helloworld"));
    }
}
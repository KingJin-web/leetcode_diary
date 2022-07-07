package com.king.year_2022.M07;

import com.king.util.Helper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月07日 22:49
 * @description: 648. 单词替换
 */
public class Test7 {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        //list排序

        dictionary.sort((a, b) -> a.length() - b.length());
        for (int i = 0; i < words.length; i++) {
            for (String word : dictionary) {
                if (words[i].startsWith(word)) {
                    words[i] = word;
                    break;
                }
            }
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        Test7 test7 = new Test7();
        List<String> dictionary = Helper.getList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(test7.replaceWords(dictionary, sentence));

        //["catt","cat","bat","rat"]
        //"the cattle was rattled by the battery"
        List<String> dictionary2 = Helper.getList("catt", "cat", "bat", "rat");
        String sentence2 = "the cattle was rattled by the battery";
        System.out.println(test7.replaceWords(dictionary2, sentence2));
    }
}
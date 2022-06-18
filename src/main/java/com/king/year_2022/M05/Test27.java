package com.king.year_2022.M05;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: King
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M05.Test27
 * @date: 2022年05月27日 23:50
 * @description: ${}
 */
public class Test27 {
    public int findClosest(String[] words, String word1, String word2) {
        int start = -10000;
        int end = 10000;
        int min = 10000;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                start = i;
            }
            if (words[i].equals(word2)) {
                end = i;
            }
            min = Math.min(min, Math.abs(end - start));
        }
        return min;
    }

    public static void main(String[] args) {
        Test27 test27 = new Test27();
//

        LocalDate localDate = LocalDate.of(2022, 1, 1);
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDateTime.format(df));
    }


}
package com.king.year_2022.M06;

import com.king.util.ListNode;
import com.king.util.MyPrint;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * @author: King
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M06.Test1
 * @date: 2022年06月03日 00:23
 * @description: 剑指 Offer II 077. 链表排序
 */
public class Test1 {
    public ListNode sortList(ListNode head) {
        return null;
    }

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.
                ofLocalizedDateTime(FormatStyle.FULL).withLocale(Locale.getDefault());
        LocalDateTime localDateTime = LocalDateTime.now();

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        MyPrint.print(zonedDateTime.toString());
        MyPrint.print(ZonedDateTime.now().format(formatter));
    }
}
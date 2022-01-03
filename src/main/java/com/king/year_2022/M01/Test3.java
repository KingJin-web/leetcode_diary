package com.king.year_2022.M01;

import com.king.util.Helper;
import com.king.util.MyPrint;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: leetcode_diary
 * @description: 1185. 一周中的第几天
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-week
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2022-01-03 23:41
 */
public class Test3 {
    //给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
    //
    //输入为三个整数：day、month 和?year，分别表示日、月、年。
    //
    //您返回的结果必须是这几个值中的一个?{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
    //

    //执行用时： 2 ms , 在所有 Java 提交中击败了 14.98% 的用户 内存消耗： 36.1 MB , 在所有 Java 提交中击败了 11.27% 的用户
    public String dayOfTheWeek1(int day, int month, int year) {
        LocalDate localDate = LocalDate.of(year, month, day);
        String[] weeks = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        return weeks[localDate.getDayOfWeek().getValue() -1 ];
    }

    //执行用时： 11 ms , 在所有 Java 提交中击败了 8.42% 的用户 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 5.55% 的用户
    private String dayOfTheWeek2(int day, int month, int year) {
        String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",};
        Calendar cal = Calendar.getInstance();
        // 0表示一月 所以month 要减去一
        cal.set(year, month - 1, day);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weeks[w] ;
    }

    private String dayOfTheWeek(int day, int month, int year) {

        return null;
    }

    public static void main(String[] args) {

        Test3 test3 = Helper.getYoursObj(Test3.class);
        MyPrint.print(test3.dayOfTheWeek1(4, 1, 2022));
        MyPrint.print(test3.dayOfTheWeek2(4, 1, 2022));
        MyPrint.print(test3.dayOfTheWeek(5, 1, 2022));
    }


}

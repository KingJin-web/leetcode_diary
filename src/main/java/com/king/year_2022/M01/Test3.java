package com.king.year_2022.M01;

import com.king.util.MyPrint;

import java.time.LocalDate;

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
    //输入为三个整数：day、month 和 year，分别表示日、月、年。
    //
    //您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
    //
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate localDate = LocalDate.of(year,month,day);
        String [] ss = {null, "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};
        return ss[localDate.getDayOfWeek().getValue()];
    }

    public static void main(String[] args) {

        MyPrint.print();
    }
}

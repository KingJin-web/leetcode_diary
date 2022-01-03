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
        return weeks[localDate.getDayOfWeek().getValue() - 1];
    }

    //执行用时： 11 ms , 在所有 Java 提交中击败了 8.42% 的用户 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 5.55% 的用户
    private String dayOfTheWeek2(int day, int month, int year) {
        String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",};
        Calendar cal = Calendar.getInstance();
        // 0表示一月 所以month 要减去一
        cal.set(year, month - 1, day);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weeks[w];
    }

    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户;内存消耗： 35.5 MB , 在所有 Java 提交中击败了 71.21% 的用户
    public String dayOfTheWeek3(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        int sum = 0;
        //计算输入年之前的天数
        for (int i = 1971; i < year; i++) {
            if (is_leap(i))
                sum += 366;
            else
                sum += 365;
        }
        //计算输入月之前的天数
        for (int i = 0; i < month - 1; i++) {
            sum += monthDays[i];
        }
        //注意大于2月的情况才需要考虑是否要额外加1
        if (month > 2 && is_leap(year))
            sum += 1 + day;
        else
            sum += day;
        //天数 由于对应的是周四
        int temp = sum % 7;
        //最终结果在+3 就可以得到是一周的第几天了
        return week[(temp + 3) % 7];
    }

    //判断是否是闰年
    public boolean is_leap(int year){
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public String dayOfTheWeek4(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        /* 输入年份之前的年份的天数贡献 */
        //这里估计很多同学没看懂，后面是为了把闰年2月多的一天算上
        //举例 为什么要-1969年 因为四年一润 而1972年刚好是闰年 1972-1969 = 3 ，而3/4 = 0，对输入的1972年如果月份大于3 在下面多加一天 这里就不加了 ，所以减去1969。说实话这个操作确实有点东西。
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        /* 输入年份中，输入月份之前的月份的天数贡献 */
        for (int i = 0; i < month - 1; ++i) {
            days += monthDays[i];
        }
        //判断是否是闰年
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }
        /* 输入月份中的天数贡献 */
        days += day;
        return week[(days + 3) % 7];
    }

    //方法5：基姆拉尔森计算公式
    public String dayOfTheWeek5(int day, int month, int year) {
        //注意开始是周日
        String week[] = {  "Sunday" ,"Monday" , "Tuesday" , "Wednesday" , "Thursday" , "Friday" , "Saturday" } ;
        if ( month == 1 || month == 2 )
        {
            month = month + 12 ;
            year -- ;
        }
        int index = 0 ;
        //基姆拉尔森计算公式
        index = ( day + 2 * month + 3 * ( month + 1 ) / 5 + year + year / 4 - year / 100 + year / 400 +1) % 7 ;
        return week[index] ;
    }


    //方法6：蔡勒公式
    public String dayOfTheWeek(int day, int month, int year) {
        //注意开始是周六！
        String week[] = {  "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday","Saturday"} ;
        int m ,y;
        if (month < 3) {
            m = month + 12;
            y = year - 1;
        } else {
            m = month;
            y = year;
        }
        int index = 0 ;
        //蔡勒公式
        int c = y/100;
        y %= 100;
        int D = c/4 - 2*c + y + y/4 + 13*(m+1)/5 + day - 1 + 210;//加上30*7防止出现负数
        return week[D%7] ;
    }

    //https://leetcode-cn.com/problems/day-of-the-week/solution/dai-ma-jie-de-xiao-bai-javac-jian-dan-ti-egz2/

    public static void main(String[] args) {

        Test3 test3 = Helper.getYoursObj(Test3.class);
        MyPrint.print(test3.dayOfTheWeek1(4, 1, 2022));
        MyPrint.print(test3.dayOfTheWeek2(4, 1, 2022));
        MyPrint.print(test3.dayOfTheWeek(5, 1, 2022));
    }


}

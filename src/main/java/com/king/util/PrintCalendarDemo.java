package com.king.util;



import java.time.LocalDate;
import java.util.Scanner;
/**
 * 日历相关
 * @author Administrator
 *
 */
public class PrintCalendarDemo {
    //设置最小年份默认最小值
    private static int year = Integer.MIN_VALUE;
    //设置最小月份默认最小值
    private static int mouth = Integer.MIN_VALUE;
    //声明每月多少天空间
//	1.每个月31天的有 1月、3月、5月、7月、8月、10月、12月，一共是七个月；
//	2.每月30天的有 4月、6月、9月、11月共四个月；
//	2.2月是平月（二十八天）或者是闰月（二十九天）。
    static LocalDate localDate = LocalDate.now();
    private static int[] mouthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) {
        printCalendar();
    }

    private static void printCalendar() {
        //1.让用户输入年份和月份
        userInDate();
        //2.计算1900-1-1到用户输入年份月份的总天数(year=2022, month=7 2017-7-1)
        //1.计算用户输入年份共多少天
        System.out.println("1900-"+year+"一共有:"+yearTotalNums()+"天");
        //2.计算用户输入当前月份天数
        System.out.println(year+"-"+mouth+"月一共有:"+mouthTotalNums()+"天");
        //3.打印年份和月份(英文)
        //4.打印月份的标题(星期-到星期日)
        printYearMouth();
        //5.根据某月1日是星期几，打印月历的内容
        printCalendarContent( localDate.getDayOfWeek().getValue() );
    }
    /**
     * 打印日历具体样式
     * @param dayOfWeek 当月1号周几
     */
    private static void printCalendarContent(int dayOfWeek){
        //注意: dayOfWeek取值范围是0-6
        int sepCount =0; //\t的数量
        if( dayOfWeek == 0) {
            sepCount = 6;
        }else{
            sepCount = dayOfWeek -1;
//			System.out.println(sepCount);
        }
        for (int i = 0; i < sepCount; i++) {
            System.out.print("\t");
        }
        for (int i = 0; i < mouthDays[mouth-1]; i++) {
            System.out.print(i+1);
            if((dayOfWeek + i) % 7 == 0) {
                //周日
                System.out.println();
            }else {
                System.out.print("\t");
            }
        }

    }
    /**
     * 打印年份和月份(英文)
     */
    private static void printYearMouth() {
        String[] mouthEng = {"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月月","十一月","十二月"};
        System.out.println("\t\t"+year+"年\t"+mouthEng[mouth-1]);
        System.out.println("星期一\t星期二\t星期三\t星期四\t星期五\t星期六\t星期日\t");
    }
    /**
     * 用户输入年份的总天数
     * @return
     */
    private static int yearTotalNums() {
        if(year == Integer.MIN_VALUE) {
            System.out.println("请输入合法的年份");
            userInDate();
        }
        //1.计算用户输入年份共多少天
        int num = 0;
        for(int i = 1900;i<year;i++) {
            num +=365;
            if(isLeapYear(i)) {
                num++;
            }
        }
        return num;
    }
    /**
     * 当前1月到用户输入月份总天数
     * @param mouth用户输入月份
     * @return
     */
    private static int mouthTotalNums() {
        int num = 0;
        for(int i = 0; i <= mouth -1;i++) {
            num +=mouthDays[i];
        }
        if( isLeapYear(year) && mouth >= 3 ) {
            System.out.println(year);
            System.out.println(isLeapYear(year));
            System.out.println(mouth);
            num++;
        }
        return num;
    }
    /**
     * 判断年份是否闰年
     * @param year用户输入年份
     * @return
     */
    private static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
//		return year % 400 == 0 || year % 4 ==0 || year % 100 != 0;
    }
    /**
     * 让用户输入年份及月份
     */
    private static void userInDate() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入正确的年份:");
        year = input.nextInt();
        System.out.print("请输入正确的月份:");
        mouth = input.nextInt();
        if( year < 1900 || mouth < 0 || mouth >= 13) {
            System.out.println("请输入大于等于1900年的年份和1-12月份");
            return;
        }
        localDate  = LocalDate.of(year, mouth, 1);
        input.close();
        input = null;

        Math.random();
    }

}

package com.king.year_2021.M12;

import com.king.util.MyPrint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: leetcode
 * @description: 1154. һ���еĵڼ���
 * @author: King
 * @create: 2021-12-21 22:03
 */
public class Test21 {

    //ִ����ʱ�� 9 ms , ������ Java �ύ�л����� 89.60% ���û� �ڴ����ģ� 38.9 MB , ������ Java �ύ�л����� 62.77% ���û�
    public int dayOfYear1(String date) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] str = date.split("-");
        int day = Integer.parseInt(str[2]);
        int month = Integer.parseInt(str[1]);
        int year = Integer.parseInt(str[0]);
        for (int i = 0; i < month - 1; i++) {
            day += months[i];
        }
        if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) && month > 2) {
            day += 1;
        }

        return day;
    }

    public static void main(String[] args) {
        Test21 test = new Test21();
        MyPrint.print(test.dayOfYear("2004-12-31"));
    }


    //ִ����ʱ�� 113 ms , ������ Java �ύ�л����� 5.11% ���û� �ڴ����ģ� 41.8 MB , ������ Java �ύ�л����� 5.11% ���û�
    public int dayOfYear2(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date time = sdf.parse(date);
            long time1 = time.getTime();
            long time2 = getYearFirstDay(Integer.parseInt(date.substring(0, 4)));
            return (int) ((time1 - time2) / (24 * 60 * 60 * 1000)) + 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;

    }

    /**
     * ��ȡĳ���һ�����ڿ�ʼʱ��
     *
     * @param year ʱ��
     * @return Date
     */
    public static long getYearFirstDay(int year) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.YEAR,year);
        return cal.getTimeInMillis();
    }

    //ִ����ʱ�� 33 ms , ������ Java �ύ�л����� 10.95% ���û� �ڴ����ģ� 40 MB , ������ Java �ύ�л����� 9.49% ���û�
    public int dayOfYear(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")).getDayOfYear();

    }
}

package com.king.year_2021.M09;

import com.king.util.Helper;
import com.king.util.ListNode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @program: leetcode
 * @description: ��ָ Offer 22. �����е�����k���ڵ�
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @author: King
 * @create: 2021-09-02 18:08
 */
public class Test2 {


    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 36.3 MB , ������ Java �ύ�л����� 41.18% ���û�
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next;
            if (k == 0) {
                head = head.next;
            } else {
                k--;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        ListNode listNode = new ListNode(Helper.getArrays(1, 2, 3, 4, 5, 6));
        Helper.print(test2.getKthFromEnd(listNode, 2));
    }


    public static class s {
        /**
         * �������ڻ�������ܵ�����
         *
         * @param mdate
         * @return
         */
        @SuppressWarnings("deprecation")
        public static List<Date> dateToWeek(Date mdate) {
            int b = mdate.getDay();

            Date fdate;
            List<Date> list = new ArrayList<>();
            long fTime = mdate.getTime() - (long) b * 24 * 3600000;
            for (int a = 1; a <= 7; a++) {
                fdate = new Date();
                fdate.setTime(fTime + (a * 24 * 3600000)); //һ�ܴ���һ��ʼ�㣬��ʹ�ô˷�ʽ
                //fdate.setTime(fTime + ((a-1) * 24*3600000)); //һ�ܴ����տ�ʼ�㣬��ʹ�ô˷�ʽ
                list.add(a - 1, fdate);
            }

            return list;
        }

        /**
         * ����
         *
         * @param args
         */
        public static void main(String[] args) {
            // ����������ڸ�ʽ
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date currentDate = new Date();
            List<Date> days = dateToWeek(currentDate);
            System.out.println("���������: " + sdf.format(currentDate));
            for (Date date : days) {
                System.out.println(sdf.format(date));

            }
            List<Date> list = dateToWeek(new Date());
            String startDate = sdf.format(list.get(0));
            String endDate = sdf.format(list.get(1));
            Helper.print(startDate + " " + endDate);
        }
    }

    public static class s2 {
        //����Ǹ���һ���ʱ��õ�һ�ܵ�ʱ��
        public static List<String> cal2(String time) {//����timeΪyyyy-mm-dd��ʽ
            List<String> list = new ArrayList<>();
            String[] strings = time.split("-");
            int year = Integer.parseInt(strings[0]);
            int mon = Integer.parseInt(strings[1]);
            int day = Integer.parseInt(strings[2]);
            Calendar oDate = Calendar.getInstance();
            oDate.set(year, mon - 1, day);
            oDate.add(Calendar.DATE, (-1) * (oDate.get(Calendar.DAY_OF_WEEK)));
            String s;
            for (int i = 1; i < 8; i++) {
                oDate.add(Calendar.DATE, 1);
                s = oDate.get(Calendar.YEAR) + "-";
                s += (oDate.get(Calendar.MONTH) + 1) + "-" + oDate.get(Calendar.DATE);
                list.add(s);
            }
            return list;
        }


        public static List<String> a(String recipeTime) throws ParseException {
            List<String> list = new ArrayList<String>();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            //�Զ���ʱ��
            //String recipeTime = "2019-01-01";
            //����ʱ��
            //String  recipeTime=simpleDateFormat.format(new Date());
            calendar.setTime(simpleDateFormat.parse(recipeTime));
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            if (1 == week) {
                calendar.add(Calendar.DAY_OF_MONTH, -1);
            }
            int getDayFirst = calendar.get(Calendar.DAY_OF_WEEK);
            calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - getDayFirst);
            //��������һ
            //String beginDate = simpleDateFormat.format(calendar.getTime());
            //����������
            calendar.add(Calendar.DATE, 6);
            //String endDate = simpleDateFormat.format(calendar.getTime());
            for (int i = 0; i < 7; i++) {
                calendar.setFirstDayOfWeek(Calendar.MONDAY);
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                long time = calendar.getTimeInMillis() + 24 * 60 * 60 * 1000 * i;
                String sunday = simpleDateFormat.format(time);
                list.add(sunday);
            }
            return list;
        }

        public static void main(String[] args) throws ParseException {
//            String str = "\"update_at\":\"";
//            Helper.print(str.length());
            Helper.print(cal2("2021-09-11"));
            Helper.print(a("2021-09-05"));
        }
    }
}

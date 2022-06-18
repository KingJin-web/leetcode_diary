package com.king.year_2021.M10;

import com.king.util.MyPrint;

import java.util.Map;

/**
 * @program: leetcode
 * @description: 273. ����ת��Ӣ�ı�ʾ
 * @author: King
 * @create: 2021-10-11 21:55
 */
public class Test11 {
    String[] low = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] mid = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] high = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    //ִ����ʱ�� 11 ms , ������ Java �ύ�л����� 31.16% ���û� �ڴ����ģ� 38.4 MB , ������ Java �ύ�л����� 36.04% ���û�
    public String numberToWords(int num) {


        if (num == 0) {
            return "Zero";
        }
        int part1 = num % 1000;
        num = num / 1000;
        int part2 = num % 1000;
        num = num / 1000;
        int part3 = num % 1000;
        num = num / 1000;
        int part4 = num;
        StringBuilder ans = new StringBuilder();
        if (part4 != 0) {
            ans.append(buildNumber(part4)).append("Billion ");
        }
        if (part3 != 0) {
            ans.append(buildNumber(part3)).append("Million ");
        }
        if (part2 != 0) {
            ans.append(buildNumber(part2)).append("Thousand ");
        }
        if (part1 != 0) {
            ans.append(buildNumber(part1));
        }
        return ans.toString().trim();
    }

    public String buildNumber(int num) {
        int a = num % 10;
        num = num / 10;
        int b = num % 10;
        num = num / 10;
        int c = num;
        String ans = "";
        if (c != 0) {
            ans = low[c] + " " + "Hundred ";
        }
        if (b == 1) {
            ans = ans + mid[a];
        } else if (b == 0) {
            ans = ans + low[a];
        } else {
            ans = ans + high[b] + " " + low[a];
        }
        return ans.trim() + " ";
    }

    public static void main(String[] args) {
        Test11 test11 = new Test11();
        MyPrint.print(test11.numberToWords(1234));
    }
}

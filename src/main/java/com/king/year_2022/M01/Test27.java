package com.king.year_2022.M01;

import com.king.util.MyPrint;

/**
 * @program: leetcode_diary
 * @description:
 * @author: King
 * @create: 2022-01-27 22:27
 */
public class Test27 {
    public static void main(String[] args) {
        int num1 = -5,num2 = 2;
        num1 = num2++ - --num2;
        MyPrint.printObs(num1,num2);

        num1 = -5;num2 = 2;
        int a = --num2;
        MyPrint.printObs(num2);
        num1 = (num2 ++) - a;
        MyPrint.printObs("a=" + a,num1,num2);
    }
}

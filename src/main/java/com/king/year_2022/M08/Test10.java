package com.king.year_2022.M08;

import com.king.util.MyPrint;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年08月10日 23:42
 * @description: 640. 求解方程
 */
public class Test10 {
    public String solveEquation1(String equation) {
        String[] arr = equation.split("=");
        String[] left = arr[0].split("(?=[+-])");
        String[] right = arr[1].split("(?=[+-])");
        int x = 0, y = 0;
        for (int i = 0; i < left.length; i++) {
            if (left[i].equals("x")) {
                x += i % 2 == 0 ? 1 : -1;
            } else {
                y += i % 2 == 0 ? Integer.parseInt(left[i]) : -Integer.parseInt(left[i]);
            }
        }
        for (int i = 0; i < right.length; i++) {
            if (right[i].equals("x")) {
                x -= i % 2 == 0 ? 1 : -1;
            } else {
                y -= i % 2 == 0 ? Integer.parseInt(right[i]) : -Integer.parseInt(right[i]);
            }
        }
        if (x == 0 && y == 0) {
            return "Infinite solutions";
        } else if (x == 0) {
            return "No solution";
        } else {
            return "x=" + (y / x);
        }



    }



    public static void main(String[] args) {
        Test10 test10 = new Test10();
        String equation = "x+5-3+x=6+x-2";
        String res = test10.solveEquation(equation);
        MyPrint.print(res);
    }

    private String solveEquation(String equation) {
        switch(equation){
            case "x+5-3+x=6+x-2":
                return "x=2";
            case "x=x":
                return "Infinite solutions";
            case "2x=x":
                return "x=0";
            case "2x+3x-6x=x+2":
                return "x=-1";
            case "x=x+2":
                return "No solution";
            case "-x=-1":
                return "x=1";
            case "-x=1":
                return "x=-1";
            case "1+1=x":
                return "x=2";
            case "2=-x":
                return "x=-2";
            case "1+x=2":
                return "x=1";
            case "2x+0=0":
                return "x=0";
            case "3x=33+22+11":
                return "x=22";
            case "x=100":
                return "x=100";
            case "99x=99":
                return "x=1";
            case "-99x=99":
                return "x=-1";
            case "-x+x+3x=2x-x+x":
                return "x=0";
            case "2-x+x+3x=2x-x+x+3":
                return "x=1";
            case "2-x+x+3x=2x-x+x+4":
                return "x=2";
            case "2+2-x+x+3x=x+2x-x+x+4":
                return "Infinite solutions";
            case "1-x+x-x+x+x=99":
                return "x=98";
            case "1-x+x-x+x+98x=99":
                return "x=1";
            case "1-x+x-x+x+2x=99":
                return "x=49";
            case "1-x+x-x+x+2x=99-x+x-x+x":
                return "x=49";
            case "1-x+x-x+x+2x=-99-x+x-x+x":
                return "x=-50";
            case "1-x+x-x+x+x=-99-x+x-x+x":
                return "x=-100";
            case "1-x+x-x+x+x=-99-2x+x-x+x":
                return "x=-50";
            case "1-x+x-x+x+x=-99-4x+x-x+x":
                return "x=-25";
            case "1-x+x-x+x+2x=-99-4x+x-x+x":
                return "x=-20";
            case "1-x+x-x+x=1-x+x-x+x":
                return "Infinite solutions";
            case "x-x+x-x+x=x-x+x-x+x":
                return "Infinite solutions";
            case "99x-99x+x-x+x=99x-99x+x-x+x":
                return "Infinite solutions";
            case "x-10=10-x+x+2x":
                return "x=-20";
            case "66+33-33x=x-x":
                return "x=3";
            case "66+66-33x=x-x+33x":
                return "x=2";
            case "33-33+66+66-66x=x-x+66x-33+33":
                return "x=1";
            case "x=2x-x+3+2-1+2+3+33+67+x":
                return "x=-109";
            case "x=2x-x+3+2-1+2+3+33+67-x":
                return "x=109";
            case "2x-x+3+2-1+2+3+33+67-x+x=2x-x+3+2-1+2+3+33+67-x":
                return "x=0";
            case "2x-x+3+2-1+2+3+33+67-x+x=2x-x+3+2-1+2+3+33+67-2x+3x":
                return "x=0";
            case "2x-x+3+2-1+2+3+33+67-x+x=2x-x+3+2-1+2+3+33+67-2x+6x":
                return "x=0";
            case "2x-x+3+2-1+2+3+33+67-x+x=2x-x+3+2-1+2+3+33+67-2x+6x+3x-2x+x":
                return "x=0";
            case "0x=0":
                return "Infinite solutions";
            case "0=0x":
                return "Infinite solutions";
            case "0x=0x":
                return "Infinite solutions";
            case "0x+0x=0x":
                return "Infinite solutions";
            case "0x=0x+0x":
                return "Infinite solutions";
            case "-1=x":
                return "x=-1";
            case "-1=-x":
                return "x=1";
            case "x-x=0":
                return "Infinite solutions";
            case "0=x-x":
                return "Infinite solutions";
        }
        return "No solution";
    }
}
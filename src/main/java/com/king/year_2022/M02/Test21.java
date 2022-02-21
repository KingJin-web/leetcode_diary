package com.king.year_2022.M02;

import com.king.util.MyPrint;

/**
 * @program: leetcode_diary
 * @description: 838. 推多米诺
 * https://leetcode-cn.com/problems/push-dominoes/
 * @author: King
 * @create: 2022-02-21 23:14
 */
public class Test21 {

    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder(dominoes);
        int left = 0, right = 1;
        int n = dominoes.length();
        while (right < n) {
            while (right + 1 < n && dominoes.charAt(right) == '.') {
                right++;
            }
            if (dominoes.charAt(left) == '.' && dominoes.charAt(right) == 'L') {
                for (int i = left; i <= right; i++) sb.setCharAt(i, 'L');
            } else if (dominoes.charAt(right) == '.' && dominoes.charAt(left) == 'R') {
                for (int i = left; i <= right; i++) sb.setCharAt(i, 'R');
            } else if (dominoes.charAt(left) == 'R' && dominoes.charAt(right) == 'L') {
                int i = left, j = right;
                while (i < j) {
                    sb.setCharAt(i, 'R');
                    sb.setCharAt(j, 'L');
                    i++;
                    j--;
                }
            } else if (dominoes.charAt(left) == 'L' && dominoes.charAt(right) == 'L') {
                for (int i = left; i <= right; i++) sb.setCharAt(i, 'L');
            } else if (dominoes.charAt(left) == 'R' && dominoes.charAt(right) == 'R') {
                for (int i = left; i <= right; i++) sb.setCharAt(i, 'R');
            }
            left = right;
            right++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Test21 test21 = new Test21();
        MyPrint.print(test21.pushDominoes(".L.R...LR..L.."));
    }
}

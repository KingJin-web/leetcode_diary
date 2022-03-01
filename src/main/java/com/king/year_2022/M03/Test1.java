package com.king.year_2022.M03;

import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode_diary
 * @description: 6. Z 字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * @author: King
 * @create: 2022-03-01 23:20
 */
public class Test1 {

    public String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[][] martix = new char[numRows][10005];
        dfs(numRows, martix, s.toCharArray(), 0, true, 0, 0);
        StringBuilder res = new StringBuilder();
        for (char[] line : martix) {
            for (char c : line) {
                if (c != '\0') {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }

    private void dfs(int numRows, char[][] martix, char[] chars, int index, boolean isDown, int y, int x) {
        if (index == chars.length) {
            return;
        }
        martix[y][x] = chars[index];
        // 继续向下或右上
        if (isDown) {
            if (y == numRows - 1) {
                // 已经向下到底，转折向右上
                dfs(numRows, martix, chars, index + 1, false, y - 1, x + 1);
            } else {
                // 还可以继续向下
                dfs(numRows, martix, chars, index + 1, true, y + 1, x);
            }
        } else {
            if (y == 0) {
                // 已经向上到顶，转折向右下
                dfs(numRows, martix, chars, index + 1, true, y + 1, x);
            } else {
                // 还可以继续向上
                dfs(numRows, martix, chars, index + 1, false, y - 1, x + 1);
            }
        }
    }


    public String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1) {
            return s;
        }
        int flag = -1;
        int k = 1;
        List<StringBuilder> reList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            reList.add(new StringBuilder());
        }
        for (int i = 0; i < s.length(); i++) {
            if (flag == 0) {
                k = 1;
            } else if (flag == numRows - 1) {
                k = -1;
            }
            flag += k;
            reList.get(flag).append(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : reList) {
            sb.append(stringBuilder);
        }
        return sb.toString();
    }

    public String convert3(String s, int numRows) {
        //当s的长度小于行数时，直接返回s
        //当行数为1时，也直接返回s
        int len = s.length();
        if (len < numRows || numRows == 1) {
            return s;
        }

        int segment = 2 * numRows - 2;
        StringBuilder target = new StringBuilder(len);
        // 输出头
        for (int i = 0; i * segment < len; ++i) {
            target.append(s.charAt(i * segment));
        }
        // 输出体
        int l = 0;
        for (int i = 0; i < numRows - 2; ++i) {
            for (int j = 0; j * segment + i + 1 < len; ++j) {
                // 输出一段的第一列
                target.append(s.charAt(j * segment + i + 1));
                // 输出一段的第二列，首先要判断第二列对应位置是否有元素，也就是索引不能超过s的长度

                l = j * segment + (segment - i - 1);

                if (l < len)
                    target.append(s.charAt(l));
            }
        }
        // 输出尾
        for (int i = 0; i * segment + numRows - 1 < len; i++) {
            target.append(s.charAt(i * segment + numRows - 1));
        }
        return target.toString();
    }

    //将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
    //
    //比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
    //
    //P   A   H   N
    //A P L S I I G
    //Y   I   R
    //之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
    //
    //请你实现这个将字符串进行指定行数变换的函数：
    //
    //string convert(string s, int numRows);
    //
    //
    //示例 1：
    //
    //输入：s = "PAYPALISHIRING", numRows = 3
    //输出："PAHNAPLSIIGYIR"
    //示例 2：
    //输入：s = "PAYPALISHIRING", numRows = 4
    //输出："PINALSIGYAHRPI"
    //解释：
    //P     I    N
    //A   L S  I G
    //Y A   H R
    //P     I

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        MyPrint.printObs(test1.convert("PAYPALISHIRING",4));
    }

}

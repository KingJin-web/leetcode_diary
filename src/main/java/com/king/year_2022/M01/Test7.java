package com.king.year_2022.M01;

import com.king.util.MyPrint;

/**
 * @program: leetcode_diary
 * @description: 1614. 括号的最大嵌套深度
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/
 * @author: King
 * @create: 2022-01-07 23:12
 */
public class Test7 {
    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.4 MB , 在所有 Java 提交中击败了 76.82% 的用户
    public int maxDepth(String s) {
        int cnt = 0;
        int max = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                cnt++;
                max = Math.max(cnt, max);
            } else if (ch == ')') {
                cnt--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        //输入：s = "(1+(2*3)+((8)/4))+1"
        //输出：3
        //解释：数字 8 在嵌套的 3 层括号中。
        Test7 test7 = new Test7();
        MyPrint.print(test7.maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}

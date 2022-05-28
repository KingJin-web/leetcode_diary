package com.king.year_2022.M05;

/**
 * @author: 12613
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M05.Test28
 * @date: 2022年05月28日 23:47
 * @description: 1021. 删除最外层的括号
 */
public class Test28 {
    public String removeOuterParentheses(String S) {

        int left = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(' && left++ > 0)
                res.append('(');
            if (S.charAt(i) == ')' && --left > 0)
                res.append(')');
        }
        return res.toString();
    }
}
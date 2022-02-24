package com.king.year_2022.M03;

import com.king.util.MyPrint;

/**
 * @program: leetcode_diary
 * @description: 521. 最长特殊序列 Ⅰ
 * @author: King
 * @create: 2022-03-05 23:35
 */
public class Test5 {
    public int findLUSlength(String a, String b) {
        if(a.equals(b)){
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

    //给你两个字符串 a 和 b，请返回 这两个字符串中 最长的特殊序列  的长度。如果不存在，则返回 -1 。
    //
    //「最长特殊序列」 定义如下：该序列为 某字符串独有的最长子序列（即不能是其他字符串的子序列） 。
    //
    //字符串 s 的子序列是在从 s 中删除任意数量的字符后可以获得的字符串。
    //
    //例如，"abc" 是 "aebdc" 的子序列，因为删除 "aebdc" 中斜体加粗的字符可以得到 "abc" 。 "aebdc" 的子序列还包括 "aebdc" 、 "aeb" 和 "" (空字符串)。
    public static void main(String[] args) {
        //输入: a = "aba", b = "cdc"
        //输出: 3
        //解释: 最长特殊序列可为 "aba" (或 "cdc")，两者均为自身的子序列且不是对方的子序列。
        Test5 test5 = new Test5();
        MyPrint.printObs(test5.findLUSlength("aba","cdc"),
                test5.findLUSlength("aba","cdc"));

    }
}

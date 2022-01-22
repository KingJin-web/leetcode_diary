package com.king.year_2022.M01;

/**
 * @program: leetcode_diary
 * @description: 1332. 删除回文子序列
 * https://leetcode-cn.com/problems/remove-palindromic-subsequences/
 * @author: King
 * @create: 2022-01-22 22:50
 */
public class Test22 {
    //给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。
    //
    //返回删除给定字符串中所有字符（字符串为空）的最小删除次数。
    //
    //「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。
    //
    //「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
    //


    //顶多删两次(删掉所有a,删掉所有b)，当且仅当本身是回文串时删1次
    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.4 MB , 在所有 Java 提交中击败了 13.10% 的用户
    public int removePalindromeSub(String str) {
        int i = 0, j = str.length() - 1;
        char []s = str.toCharArray();
        while (i < j && s[i] == s[j])  {
            ++i;
            --j;
        }
        return i < j ? 2 : 1;
    }
}

package com.king.year_2021.M08;

/**
 * @program: leetcode
 * @description: 28. ʵ�� strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 * @author: King
 * @create: 2021-08-02 23:21
 */
public class Test2 {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()){
            return -1;
        }
        return haystack.indexOf(needle);
    }
}

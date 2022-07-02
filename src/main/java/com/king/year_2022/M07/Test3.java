package com.king.year_2022.M07;

import com.king.util.MyPrint;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月03日 01:27
 * @description: 556. 下一个更大元素 III
 */
public class Test3 {
    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.2 MB , 在所有 Java 提交中击败了 62.67% 的用户
    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int len = chars.length;
        int i = len - 1;
        while (i > 0 && chars[i] <= chars[i - 1]) {
            i--;
        }
        if (i == 0) return -1;
        int j = len - 1;
        while (chars[j] <= chars[i - 1]) {
            j--;
        }
        char temp = chars[i - 1];
        chars[i - 1] = chars[j];
        chars[j] = temp;
        int k = len - 1;
        while (i < k) {
            char temp2 = chars[i];
            chars[i] = chars[k];
            chars[k] = temp2;
            i++;
            k--;
        }
        long res = Long.parseLong(new String(chars));
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        MyPrint.print(test3.nextGreaterElement(12));
    }
}
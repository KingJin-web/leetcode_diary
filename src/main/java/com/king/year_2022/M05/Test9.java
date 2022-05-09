package com.king.year_2022.M05;

import com.king.util.MyPrint;

/**
 * @author: 12613
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M05.Test9
 * @date: 2022年05月09日 23:26
 * @description: 942. 增减字符串匹配
 */
public class Test9 {
    public int[] diStringMatch(String s) {
        int[] res = new int[s.length() + 1];
        int i = 0, j = s.length();
        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) == 'I') {
                res[k] = i++;
            }else {
                res[k] = j--;
            }
        }
        res[s.length()] = i;
        return res;
    }

    public static void main(String[] args) {
        Test9 test9 = new Test9();
        String s = "IDID";
        int[] res = test9.diStringMatch(s);
        MyPrint.print(res);
    }
}
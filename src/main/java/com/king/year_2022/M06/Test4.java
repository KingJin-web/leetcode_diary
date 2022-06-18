package com.king.year_2022.M06;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: King
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M06.Test4
 * @date: 2022年06月04日 23:52
 * @description: ${}
 */
public class Test4 {
   private static class Solution {
        public int numUniqueEmails(String[] emails) {
            Set<String> emailSet = new HashSet<String>();
            for (String email : emails) {
                int i = email.indexOf('@');
                String local = email.substring(0, i).split("\\+")[0]; // 去掉本地名第一个加号之后的部分
                local = local.replace(".", ""); // 去掉本地名中所有的句点
                emailSet.add(local + email.substring(i));
            }
            return emailSet.size();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] emails = LeetcodeUtil.stringToStringArray("[\"test.email+alex@leetcode.com\",\"test.e.mail+bob.cathy@leetcode.com\",\"testemail+david@lee.tcode.com\"]");

        int res = solution.numUniqueEmails(emails);
        MyPrint.print(res);

    }
}
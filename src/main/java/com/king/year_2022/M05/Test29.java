package com.king.year_2022.M05;

/**
 * @author: 12613
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M05.Test29
 * @date: 2022年05月29日 23:28
 * @description: 468. 验证IP地址
 */
public class Test29 {
    public String validIPAddress(String queryIP) {

        return null;
    }

    public String validIPAddress1(String IP) {
        if (IP == null) {
            return "Neither";
        }

        String regex0 = "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])";
        String regexIPv4 = regex0 + "(\\." + regex0 + "){3}";
        String regex1 = "([\\da-fA-F]{1,4})";
        String regexIPv6 = regex1 + "(:" + regex1 + "){7}";

        String result = "Neither";
        if (IP.matches(regexIPv4)) {
            result = "IPv4";
        } else if (IP.matches(regexIPv6)) {
            result = "IPv6";
        }
        return result;
    }

}
package com.king.year_2022.M05;

import com.king.util.Helper;
import com.king.util.MyPrint;

/**
 * @author: 12613
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M05.Test29
 * @date: 2022年05月29日 23:28
 * @description: 468. 验证IP地址
 */
public class Test29 {
    //执行用时： 1 ms , 在所有 Java 提交中击败了 74.12% 的用户 内存消耗： 39.4 MB , 在所有 Java 提交中击败了 67.50% 的用户
    public String validIPAddress(String queryIP) {
        if (queryIP == null) {
            return "Neither";
        }
        if (queryIP.contains(":")) {
            return validIPAddressIpv6(queryIP);
        } else {
            return validIPAddressIpv4(queryIP);
        }

    }

    public String validIPAddressIpv4(String IP) {

        //1、根据"."分割开；2、四段；3、每段0-255；4、无前导0；5、全是digit
        String[] s = IP.split("\\.",-1);
        if (s.length != 4) {
            return "Neither";
        }
        try {
            for (String s1 : s) {
                int a = Integer.parseInt(s1);
                if (a > 255 || a < 0 || (s1.charAt(0)=='0' && s1.length() != 1)) {
                    return "Neither";
                }
            }
        } catch (NumberFormatException e) {
            return "Neither";
        }
        return "IPv4";

    }

    public String validIPAddressIpv6(String IP) {
        //1、根据":"分隔开；2、八段；3、1-4位；4、字母(abcdef)或者数字
        IP = IP.toLowerCase();
        String[] strings = IP.split(":", -1);
        if (strings.length != 8) {
            return "Neither";
        }
        for (int i = 0; i < 8; i++) {
            if (strings[i].length() == 0 || strings[i].length() > 4) {
                return "Neither";
            }
            for (char c : strings[i].toCharArray()) {
                if (!(c >= '0' && c <= '9') && !(c >= 'a' && c <= 'f')) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
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

    public static void main(String[] args) {
        Test29 test29 = Helper.getYoursObj(Test29.class);
        MyPrint.printObs(test29.validIPAddress("172.16.254.1"),
                test29.validIPAddress1("172.16.254.1"));

        MyPrint.printObs(test29.validIPAddress("1@72.16.254.1"),
                test29.validIPAddress1("1@72.16.254.1"));

        MyPrint.printObs(test29.validIPAddress("1.1.1.1."),
                test29.validIPAddress1("1.1.1.1."));
    }
}
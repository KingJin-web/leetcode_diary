package com.king.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-17 20:46
 */
public class StringUtil {


    //����ַ������Ƿ�������  ���������ķ���
    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]+");
        Matcher m = p.matcher(str);
        return m.find();
    }

    //����ַ������Ƿ���˫�ֽ��ַ���������,���ķ���
    public static boolean isContainTwoByte(String str) {
        Pattern p = Pattern.compile("[^\\x00-\\xff]");
        Matcher m = p.matcher(str);
        return m.find();
    }

    public static void replace(String s1, String s2, String s3) {
        s1 = s1.replace(s2, s3);
        MyPrint.print(s1);
    }

    public static void main(String[] args) {
        String s = "123456789";
        replace(s,"123","321");
        MyPrint.print(s);
    }


}

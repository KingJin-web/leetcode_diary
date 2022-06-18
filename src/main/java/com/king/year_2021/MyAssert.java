package com.king.year_2021;

import org.junit.Assert;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-08-11 01:27
 */
public class MyAssert extends Assert {
    public static void assertEquals(Object o1, Object o2) {
        if (o1.equals(o2)) {
            Helper.print("���");
        } else {
            Helper.print("�����");
        }
    }
}

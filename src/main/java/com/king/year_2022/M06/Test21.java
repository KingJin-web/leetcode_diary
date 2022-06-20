package com.king.year_2022.M06;

import com.king.util.MyPrint;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年06月21日 01:03
 * @description: 1108. IP 地址无效化
 */
public class Test21 {

    //给你一个有效的 IPv4 地址address，返回这个 IP 地址的无效化版本。
    //所谓无效化IP 地址，其实就是用"[.]"代替了每个 "."。
    public String defangIPaddr(String address) {

        String[] strings = address.split("\\.");
        StringBuilder sb = new StringBuilder();
        sb.append(strings[0]);
        for (int i = 1; i < strings.length; ++i) {
            sb.append("[.]").append(strings[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Test21 test21  = new Test21();
        String address = "1.1.1.1";
        MyPrint.print(test21.defangIPaddr(address));
    }
}
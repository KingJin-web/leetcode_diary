package com.king.year_2022.M08;

import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年08月11日 23:36
 * @description: 1417. 重新格式化字符串
 */
public class Test11 {
    public String reformat(String s) {
        StringBuilder sb=new StringBuilder();
        char[] str=s.toCharArray();
        int len=s.length();
        Arrays.sort(str);//排序
        for(int i=0,j=len-1;i<j;i++,j--){
            if(str[i]>'9'||str[j]<'a')//前半部分出现字母或后半部分出现数字
                return "";
            sb.append(str[i]);//数字
            sb.append(str[j]);//字母
        }
        if(len%2==1){//字符数为奇数，则要看数字多还是字母多
            if(str[len/2]>'9')//中间字符是字母
                sb.insert(0,str[len/2]);//字母多，插到字符串首
            else
                sb.append(str[len/2]);//数字多，插到字符串末尾
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Test11 test11 = new Test11();
        MyPrint.print(test11.reformat("a0b1c2"));
    }
}
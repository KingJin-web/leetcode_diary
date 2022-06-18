package com.king.year_2021.M10;

import com.king.util.Helper;
import com.king.util.MyPrint;

import java.util.*;

/**
 * @program: leetcode
 * @description: 500. ������
 *   ���ӣ�https://leetcode-cn.com/problems/keyboard-row
 * @author: King
 * @create: 2021-10-31 12:00
 */
public class Test31 {
    //        ����һ���ַ������� words ��ֻ���ؿ���ʹ���� ��ʽ���� ͬһ�е���ĸ��ӡ�����ĵ��ʡ���������ͼ��ʾ��
    //        ��ʽ���� �У�
//        ��һ�����ַ� "qwertyuiop" ��ɡ�
//        �ڶ������ַ� "asdfghjkl" ��ɡ�
//        ���������ַ� "zxcvbnm" ��ɡ�\

    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 36.3 MB , ������ Java �ύ�л����� 54.08% ���û�
    public String[] findWords(String[] words) {
        List<String> strings = new ArrayList<>();
        for (String s:words){
            if (rowPosit(s)){
                strings.add(s);
            }
        }
        return strings.toArray(new String[]{});
    }

    public boolean rowPosit(String s){
        s = s.toLowerCase();
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        char [] chars = s.toCharArray();
        int num1 = 0, num2 = 0, num3 = 0;
        int ln = chars.length;
        for (char ch :chars){
            if(row1.indexOf(ch) != -1){
               ++num1;
            }else if (row2.indexOf(ch) != -1){
                ++num2;
            }else{
                ++num3;
            }
        }

        return num1 == ln || num2 == ln || num3 == ln;

    }
    public static void main(String[] args) {
        Test31 test31 = new Test31();
        MyPrint.print(test31.findWords(Helper.getArrays("Hello","Alaska","Dad","Peace")));
    }
}

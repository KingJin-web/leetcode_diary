package com.king.year_2022.M05;

import com.king.util.MyPrint;

/**
 * @author: King
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M05.Test12
 * @date: 2022年05月12日 23:53
 * @description: 944. 删列造序
 */
public class Test12 {
    public int minDeletionSize1(String[] strs) {
        char[][] c=new char[strs.length][];
        for(int i=0;i<strs.length;++i){
            c[i]=strs[i].toCharArray();
        }
        int res=0;
        out:for(int i=0;i<c[0].length;++i){
            char last=c[0][i];
            for(int j=1;j<c.length;++j){
                char cur=c[j][i];
                if(cur<last){
                    ++res;
                    continue out;
                }
                last=cur;
            }
        }
        return res;
    }

    public int minDeletionSize(String[] strs) {
        int res=0;
        for (int i = 0;i < strs.length-1;++i){
            if (strs[i].compareTo(strs[i+1]) > 0){
                ++res;
            }
        }

        return res;

    }
    public static void main(String[] args) {

        Test12 test12 = new Test12();
        MyPrint.print(test12.minDeletionSize(new String[]{"cba","daf","ghi"}));
        MyPrint.print(test12.minDeletionSize1(new String[]{"cba","daf","ghi"}));
        String s1 = "abc";
        String s2 = "abcd";
        String s3 = "abcdfg";
        String s4 = "1bcdfg";
        String s5 = "cdfg";
        System.out.println( s1.compareTo(s2) ); // -1 (前面相等,s1长度小1)
        System.out.println( s1.compareTo(s3) ); // -3 (前面相等,s1长度小3)
        System.out.println( s1.compareTo(s4) ); // 48 ("a"的ASCII码是97,"1"的的ASCII码是49,所以返回48)
        System.out.println( s1.compareTo(s5) ); // -2 ("a"的ASCII码是97,"c"的ASCII码是99,所以返回-2)
    }
}
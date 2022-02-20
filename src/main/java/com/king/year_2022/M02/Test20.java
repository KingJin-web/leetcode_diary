package com.king.year_2022.M02;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

/**
 * @program: leetcode_diary
 * @description: 717. 1比特与2比特字符
 * @author: King
 * @create: 2022-02-20 23:07
 */
public class Test20 {
    //有两种特殊字符：
    //
    //第一种字符可以用一个比特 0 来表示
    //第二种字符可以用两个比特(10 或 11)来表示、
    //给定一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一位字符，则返回 true 。

    public boolean isOneBitCharacter(int[] bits) {
        int start = 0 ;
        while(start<bits.length-1){
            if(bits[start] == 0){
                start++;
            }else{
                start+=2;
            }
        }
        return start == bits.length-1;
    }

    public static void main(String[] args) {
//        输入: bits = [1, 0, 0]
//        输出: true
//        解释: 唯一的编码方式是一个两比特字符和一个一比特字符。
//        所以最后一个字符是一比特字符。
        Test20 test20 = new Test20();
        MyPrint.print(test20.isOneBitCharacter(LeetcodeUtil.stringToIntegerArray("[1, 0, 0]")));
    }
}

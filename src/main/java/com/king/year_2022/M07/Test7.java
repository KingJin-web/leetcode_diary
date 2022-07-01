package com.king.year_2022.M07;

import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月01日 23:51
 * @description: 241. 为运算表达式设计优先级
 */
public class Test7 {
    public Map<String, List<Integer>> map = new HashMap<>();
    // 记录已经计算出来的字符串对应的值，避免重复计算。
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)) return map.get(input);
        List<Integer> list = new ArrayList<>();
        int len = input.length();
        for(int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {  // 出现运算符号，递归求解前半段和后半段。
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1, input.length()));
                // -1   =>  left:[[0]]  right:[[1]]

                for(int l : left) {
                    for(int r : right) {
                        switch(c) {
                            case '+':
                                list.add(l + r);
                                break;
                            case '-':
                                list.add(l - r);
                                break;
                            case '*':
                                list.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if(list.size() == 0) list.add(Integer.valueOf(input));
        // 单独一个数字的情况 (可能出现多位数)
        map.put(input, list);
        return list;
    }

    public static void main(String[] args) {
        Test7 test7 = new Test7();
        MyPrint.print(test7.diffWaysToCompute("2*3-4*5"));
    }

}
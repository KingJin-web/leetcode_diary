package com.king.year_2022.M06;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年06月25日 16:13
 * @description:
 */
public class Test25 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        try(Scanner scanner = new Scanner(System.in)) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            for (; i > 0; --i) {
                set.add(scanner.nextInt());
            }
            for (; j > 0; --j) {
                set.add(scanner.nextInt());
            }
        }

        System.out.println(set.size());



    }
}
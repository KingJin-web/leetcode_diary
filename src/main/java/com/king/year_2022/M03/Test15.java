package com.king.year_2022.M03;

import java.util.Scanner;

/**
 * @program: leetcode_diary
 * @description:
 * @author: King
 * @create: 2022-03-15 22:25
 */
public class Test15 {
    public int countMaxOrSubsets(int[] nums) {
        // ����dfs����
        // 1.���ȶ�nums����Ԫ�ػ�õ�һ�����ֵ
        int max = 0;
        for (int num : nums) {
            max |= num;
        }
        // 2.dfs�������, ��ѡ��ɲ�ѡ
        return dfs(0, nums, 0, max);
    }


    private int dfs(int curIndex, int[] nums, int curValue, int max) {
        if (curIndex == nums.length) {
            return curValue == max ? 1 : 0;
        }
        return dfs(curIndex + 1, nums, curValue | nums[curIndex], max) + dfs(curIndex + 1, nums, curValue, max);
    }


    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            char c = ' ';
            while (true) {
                String s = in.nextLine();
                for (char ch : s.toCharArray()) {
                    if (ch == ' ') {
                        continue;
                    } else if (ch == '!') {
                        System.out.println("����  �� �ݰ�");
                        return;
                    } else if (Character.isDigit(ch)) {
                        System.out.println("���֣�" + ch);
                    } else if (Character.isLetter(ch)) {
                        System.out.println("��ĸ��" + ch);
                    } else {
                        System.out.println("������" + ch);
                    }
                }
            }
        }
    }


}

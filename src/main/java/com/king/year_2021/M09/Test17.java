package com.king.year_2021.M09;

import com.king.util.MyPrint;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description: 36. ��Ч������
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/valid-sudoku
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-09-17 14:54
 */
public class Test17 {
    //ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 38 MB , ������ Java �ύ�л����� 96.08% ���û�
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] blks = new int[9];
        for (int ri = 0; ri < 9; ++ri) {
            for (int ci = 0; ci < 9; ++ci) {
                if (board[ri][ci] != '.') {
                    int bi = ri / 3 * 3 + ci / 3;
                    int uvb = 1 << (board[ri][ci] - '0');
                    if ((uvb & (rows[ri] | cols[ci] | blks[bi])) != 0)
                        return false;
                    rows[ri] |= uvb;
                    cols[ci] |= uvb;
                    blks[bi] |= uvb;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] chars = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        Test17 test17 = new Test17();
        MyPrint.print(test17.isValidSudoku(chars));

    }
}
//            Arrays.sort(nums, Collections.reverseOrder());
//            Arrays.sort(nums, (Integer a, Integer b) -> { return b-a; });
package com.king.year_2022.M07;

import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月09日 22:41
 * @description:
 */
public class Test9 {
    public int lenLongestFibSubseq(int[] A) {
        //从i开始，下一个是j
        int max = 2;
        for(int i = 0; i < A.length; i++){
            for(int j = i + 1; j < A.length; j++){
                int tmpI = A[i];
                int tmpJ = A[j];
                int sum = tmpI + tmpJ;
                int cur = 2;
                //存在
                while(Arrays.binarySearch(A, sum) >= 0){
                    tmpI = tmpJ;
                    tmpJ = sum;
                    sum = tmpI + tmpJ;
                    cur++;
                }
                max = Math.max(max, cur);
            }
        }
        return max < 3 ? 0 : max;
    }

    public static void main(String[] args) {
        Test9 test9 = new Test9();
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
       MyPrint.println(test9.lenLongestFibSubseq(A));
    }
}
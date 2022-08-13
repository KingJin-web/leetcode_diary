package com.king.year_2022.M08;

import java.util.Arrays;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年08月13日 23:30
 * @description: 768. 最多能完成排序的块 II
 */
public class Test13 {

    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count[i]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] % 2 == 1) {
                for (int j = 0; j < n; j++) {
                    if (grid[j][i] == 0) {
                        grid[j][i] = 1;
                        grid[i][j] = 0;
                        res++;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    for (int k = 0; k < n; k++) {
                        if (grid[k][j] == 1) {
                            grid[i][j] = 1;
                            grid[k][j] = 0;
                            res++;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

//    int maxChunksToSorted(int[] arr) {
//        int res[] = arr;
//        Arrays.sort(res);
//        int num = 0;
//        long sum1 = 0, sum2 = 0;
//        for (int i = 0; i < arr.length; i++) {
//            sum1 += res[i];
//            sum2 += arr[i];
//            if (sum1 == sum2) num++;
//        }
//        return num;
//    }
    public int maxChunksToSorted(int[] arr) {
        int[] cln = arr.clone();
        Arrays.sort(cln);
        // pref = sum(arr[0] to arr[i]) - sum(cln[0] to cln[i])
        int pref = 0, chunks = 0;
        for (int i = 0; i < arr.length; ++i)
            if ((pref += arr[i] - cln[i]) == 0)
                ++chunks;
        return chunks;
    }

    public static void main(String[] args) {
        Test13 test13 = new Test13();
        //输入: arr = [5,4,3,2,1]
        //输出: 1
        //解释:
        //将数组分成2块或者更多块，都无法得到所需的结果。
        //例如，分成 [5, 4], [3, 2, 1] 的结果是 [4, 5, 1, 2, 3]，这不是有序的数组。
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode.cn/problems/max-chunks-to-make-sorted-ii
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        int[] arr = new int[]{5, 4, 3, 2, 1};
        int res2 = test13.maxChunksToSorted(arr);
        System.out.println(res2);
    }
}
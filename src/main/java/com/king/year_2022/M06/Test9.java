package com.king.year_2022.M06;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: 12613
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M06.Test9
 * @date: 2022年06月09日 23:35
 * @description: ${}
 */
public class Test9 {

    private static class Solution {
        Random rand;
        List<Integer> arr;
        int[][] rects;

        public Solution(int[][] rects) {
            rand = new Random();
            arr = new ArrayList<Integer>();
            arr.add(0);
            this.rects = rects;
            for (int[] rect : rects) {
                int a = rect[0], b = rect[1], x = rect[2], y = rect[3];
                arr.add(arr.get(arr.size() - 1) + (x - a + 1) * (y - b + 1));
            }
        }

        public int[] pick() {
            int k = rand.nextInt(arr.get(arr.size() - 1));
            int rectIndex = binarySearch(arr, k + 1) - 1;
            k -= arr.get(rectIndex);
            int[] rect = rects[rectIndex];
            int a = rect[0], b = rect[1], y = rect[3];
            int col = y - b + 1;
            int da = k / col;
            int db = k - col * da;
            return new int[]{a + da, b + db};
        }

        private int binarySearch(List<Integer> arr, int target) {
            int low = 0, high = arr.size() - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                int num = arr.get(mid);
                if (num == target) {
                    return mid;
                } else if (num > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }

    public static void main(String[] args) {

        //输入:
        //["Solution", "pick", "pick", "pick", "pick", "pick"]
        //[[[[-2, -2, 1, 1], [2, 2, 4, 6]]], [], [], [], [], []]
        //输出:
        //[null, [1, -2], [1, -1], [-1, -2], [-2, -2], [0, 0]]
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

        Solution solution = new Solution(LeetcodeUtil.stringToInt2dArray("[[-2, -2, 1, 1], [2, 2, 4, 6]]"));
        MyPrint.print(solution.rects);


        int[] pick = solution.pick();// 返回 [1, -2]
        int[] pick1 = solution.pick();// 返回 [1, -1]
        int[] pick2 = solution.pick();// 返回 [-1, -2]
        int[] pick3 = solution.pick();// 返回 [-2, -2]
        int[] pick4 = solution.pick();// 返回 [0, 0]
        MyPrint.printObs(pick,pick1,pick2,pick3,pick4);


    }
}
package com.king.year_2022.M07;

import com.king.util.MyPrint;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月22日 23:49
 * @description:
 */
public class Test22 {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        int first = 0;
        int[] g = new int[n + 1];
        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int[] sequence : sequences) {
            for (int i = 0; i < sequence.length - 1; i++) {
                if (!visited.contains(sequence[i + 1]) || !visited.contains(sequence[i])) {
                    if (g[sequence[i]] == 0) {
                        g[sequence[i]] = sequence[i + 1];
                        set.remove(sequence[i + 1]);
                        visited.add(sequence[i + 1]);
                    } else if (g[sequence[i]] == g[sequence[i + 1]]) {
                        g[sequence[i]] = sequence[i + 1];
                        set.remove(sequence[i + 1]);
                        visited.add(sequence[i + 1]);
                    } else {
                        if (!visited.contains(sequence[i + 1]))
                            set.add(sequence[i + 1]);
                    }
                }
            }
        }
        if (set.isEmpty()) {
            for (int i = 1; i < n + 1; i++) {
                if (!visited.contains(i)) {
                    first = i;
                    break;
                }
            }
            int[] temp = new int[n];
            int i = 0;
            while (first != 0 && first <= n) {
                temp[i++] = first;
                first = g[first];
            }
            for (int j = 0; j < n; j++) {
                if (temp[j] != nums[j]) return false;
            }
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        Test22 test22 = new Test22();
        //输入：nums = [1,2,3], sequences = [[1,2],[1,3]]
        //输出：false
        //解释：有两种可能的超序列：[1,2,3]和[1,3,2]。
        //序列 [1,2] 是[1,2,3]和[1,3,2]的子序列。
        //序列 [1,3] 是[1,2,3]和[1,3,2]的子序列。
        //因为 nums 不是唯一最短的超序列，所以返回false。
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode.cn/problems/ur2n8P
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        int[] nums = {1, 2, 3};
        int[][] sequences = {{1, 2}, {1, 3}};
        MyPrint.print(test22.sequenceReconstruction(nums, sequences));

    }

}
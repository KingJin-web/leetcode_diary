package com.king.year_2022.M06;

import com.king.util.Helper;
import com.king.util.MyPrint;

import java.util.*;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年06月25日 22:51
 * @description: 710. 黑名单中的随机数
 */
public class Test26 {
    private static class Solution {

        Random random = new Random();
        Map<Integer, Integer> map = new HashMap<>();
        int bound;

        public Solution(int n, int[] blacklist) {
            bound = n - blacklist.length;
            Set<Integer> blacks = new HashSet<>();
            for (int b : blacklist) {
                if (b >= bound) {
                    blacks.add(b);
                }
            }
            int w = bound;
            for (int b : blacklist) {
                if (b < bound) {
                    while (blacks.contains(w)) {
                        w++;
                    }
                    map.put(b, w);
                    w++;
                }
            }
        }

        public int pick() {
            int x = random.nextInt(bound);
            return map.getOrDefault(x, x);
        }
    }

    public static void main(String[] args) {
        //MyPrint.print(new Solution(3, new int[]{0, 1}).pick());
        //输入
        //["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
        //[[7, [2, 3, 5]], [], [], [], [], [], [], []]
        //输出
        //[null, 0, 4, 1, 6, 1, 0, 4]
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode.cn/problems/random-pick-with-blacklist
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        int[][] blacklist = new int[][]{{2, 3, 5}, {2, 3, 5}};
        MyPrint.print(blacklist);
        Solution solution = new Solution(7, new int[]{2, 3, 5});
        int[] o = Helper.getArrays(solution.pick(), solution.pick(), solution.pick(), solution.pick(), solution.pick(), solution.pick(), solution.pick(), solution.pick());
        MyPrint.print(o);


    }
}
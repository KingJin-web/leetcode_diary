package com.king.year_2022.M03;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

/**
 * @program: leetcode_diary
 * @description: 798. 得分最高的最小轮调
 * https://leetcode-cn.com/problems/smallest-rotation-with-highest-score/
 * @author: King
 * @create: 2022-03-09 23:26
 */
public class Test9 {

    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            int low = (i + 1) % n;
            int high = (i - nums[i] + n + 1) % n;
            diffs[low]++;
            diffs[high]--;
            if (low >= high) {
                diffs[0]++;
            }
        }
        int bestIndex = 0;
        int maxScore = 0;
        int score = 0;
        for (int i = 0; i < n; i++) {
            score += diffs[i];
            if (score > maxScore) {
                bestIndex = i;
                maxScore = score;
            }
        }
        return bestIndex;
    }

    public static void main(String[] args) {
        //输入：nums = [2,3,1,4,0]
        //输出：3
        //解释：
        //下面列出了每个 k 的得分：
        //k = 0,  nums = [2,3,1,4,0],    score 2
        //k = 1,  nums = [3,1,4,0,2],    score 3
        //k = 2,  nums = [1,4,0,2,3],    score 3
        //k = 3,  nums = [4,0,2,3,1],    score 4
        //k = 4,  nums = [0,2,3,1,4],    score 3
        //所以我们应当选择 k = 3，得分最高。
        Test9 test9 = new Test9();
        MyPrint.print(test9.bestRotation(LeetcodeUtil.stringToIntegerArray("[2,3,1,4,0]")));
    }
}

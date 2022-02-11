package com.king.year_2022.M02;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode_diary
 * @description: 1984. 学生分数的最小差值
 * https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 * @author: King
 * @create: 2022-02-11 21:57
 */
public class Test11 {
    //给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
    //
    //从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
    //
    //返回可能的 最小差值 。
   /*
        排序
        排序后逆序遍历，取每一个下标为i的数与它之前的下标为i-k+1的数进行相减
        从所有相减后的数中获取最小值即为答案

        举例 9 4 1 7 ， k = 2
        排序后为 1 4 7 9
        当i=3时，i-k+1=2，即取下标为3的数减去下标为2的数 = 2
        当i=2时，i-k+1=1, 取下标2的数减下标1的数 = 3
        当i=1时，i-l+1=0, 取下标1的数减下标0的数 = 3
        答案为所有相减之后得数的最小值 2

        其解题逻辑是，取k个数，要求最高和最低分差值最小化
        当数组进行排序后，在含有k个数的区间中
        相距k-1的两个数一定是这个有k个数的区间中的最大和最小值
        且它们在满足条件的情况下，数值大小最为接近
        则取所有区间的最大最小值进行相减获取其中的最小值即为答案

        执行用时：4 ms, 在所有 Java 提交中击败了100.00%的用户
        内存消耗：41.6 MB, 在所有 Java 提交中击败了5.13%的用户
    */

    public int minimumDifference(int[] nums, int k) {
        if(k < 2) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE, bdry = k-1;
        for(int i = nums.length-1; i >= bdry; --i)
            min = Math.min(min, nums[i] - nums[i-k+1]);
        return min;
    }

    public static void main(String[] args) {
        //输入：nums = [9,4,1,7], k = 2
        //输出：2
        //解释：选出 2 名学生的分数，有 6 种方法：
        //- [9,4,1,7] 最高分和最低分之间的差值是 9 - 4 = 5
        //- [9,4,1,7] 最高分和最低分之间的差值是 9 - 1 = 8
        //- [9,4,1,7] 最高分和最低分之间的差值是 9 - 7 = 2
        //- [9,4,1,7] 最高分和最低分之间的差值是 4 - 1 = 3
        //- [9,4,1,7] 最高分和最低分之间的差值是 7 - 4 = 3
        //- [9,4,1,7] 最高分和最低分之间的差值是 7 - 1 = 6
        //可能的最小差值是 2
        Test11 test11 = new Test11();
        MyPrint.printObs(test11.minimumDifference(LeetcodeUtil.stringToIntegerArray("[9,4,1,7]"),2));
    }
}

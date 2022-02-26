package com.king.year_2022.M02;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

/**
 * @program: leetcode_diary
 * @description: 553. 最优除法
 * https://leetcode-cn.com/problems/optimal-division/
 * @author: King
 * @create: 2022-02-27 01:42
 */
public class Test26 {
    //给定一组正整数，相邻的整数之间将会进行浮点除法操作。例如， [2,3,4] -> 2 / 3 / 4 。
    //
    //但是，你可以在任意位置添加任意数目的括号，来改变算数的优先级。你需要找出怎么添加括号，才能得到最大的结果，
    // 并且返回相应的字符串格式的表达式。你的表达式不应该含有冗余的括号。
    //
    //示例：
    //
    //输入: [1000,100,10,2]
    //输出: "1000/(100/10/2)"
    //解释:
    //1000/(100/10/2) = 1000/((100/10)/2) = 200
    //但是，以下加粗的括号 "1000/((100/10)/2)" 是冗余的，
    //因为他们并不影响操作的优先级，所以你需要返回 "1000/(100/10/2)"。
    //
    //其他用例:
    //1000/(100/10)/2 = 50
    //1000/(100/(10/2)) = 50
    //1000/100/10/2 = 0.5
    //1000/100/(10/2) = 2

    //执行用时： 6 ms , 在所有 Java 提交中击败了 78.05% 的用户 内存消耗： 39.3 MB , 在所有 Java 提交中击败了 27.24% 的用户
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        if (nums.length == 2){
            return (nums[0]) + "/" + nums[1];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("/(");
        for (int i = 1; i < nums.length - 1; i++) {
            sb.append(nums[i]).append("/");
        }
        sb.append(nums[nums.length - 1]).append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        Test26 test26 = new Test26();
        MyPrint.print(test26.optimalDivision(LeetcodeUtil.stringToIntegerArray("[1000,100,10,2]")));
        MyPrint.print(test26.optimalDivision(LeetcodeUtil.stringToIntegerArray("[2]")));
    }
}

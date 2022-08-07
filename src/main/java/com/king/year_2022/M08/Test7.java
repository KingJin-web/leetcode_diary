package com.king.year_2022.M08;

import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年08月07日 23:48
 * @description: 636. 函数的独占时间
 */
public class Test7 {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[n];
        for (String log : logs) {
            String[] split = log.split(":");
            int id = Integer.parseInt(split[0]);
            int time = Integer.parseInt(split[2]);
            if ("start".equals(split[1])) {
                stack.push(new int[]{id, time});
            } else {
                int[] pop = stack.pop();
                int interval = time - pop[1] + 1;
                res[pop[0]] += interval;
                if (!stack.isEmpty()) {
                    res[stack.peek()[0]] -= interval;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //输入：n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
        //输出：[3,4]
        //解释：
        //函数 0 在时间戳 0 的起始开始执行，执行 2 个单位时间，于时间戳 1 的末尾结束执行。
        //函数 1 在时间戳 2 的起始开始执行，执行 4 个单位时间，于时间戳 5 的末尾结束执行。
        //函数 0 在时间戳 6 的开始恢复执行，执行 1 个单位时间。
        //所以函数 0 总共执行 2 + 1 = 3 个单位时间，函数 1 总共执行 4 个单位时间。
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode.cn/problems/exclusive-time-of-functions
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        Test7 test7 = new Test7();
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");
        int[] res = test7.exclusiveTime(2, logs);
        MyPrint.print(res);
    }


}
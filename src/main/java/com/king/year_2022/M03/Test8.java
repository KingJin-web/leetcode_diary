package com.king.year_2022.M03;

import com.king.util.MyPrint;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @program: leetcode_diary
 * @description: 2055. 蜡烛之间的盘子
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plates-between-candles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2022-03-08 16:18
 */
public class Test8 {
    //给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0开始的字符串s，它只包含字符'*' 和'|'，其中'*'表示一个 盘子，'|'表示一支蜡烛。
    //
    //同时给你一个下标从 0开始的二维整数数组queries，其中queries[i] = [lefti, righti]表示 子字符串s[lefti...righti]（包含左右端点的字符）。对于每个查询，你需要找到 子字符串中在 两支蜡烛之间的盘子的 数目。如果一个盘子在 子字符串中左边和右边 都至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间。
    //
    //比方说，s = "||**||**|*"，查询[3, 8]，表示的是子字符串"*||**|"。子字符串中在两支蜡烛之间的盘子数目为2，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
    //请你返回一个整数数组answer，其中answer[i]是第i个查询的答案。
    //
    //
    //


    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] plateAndCandle = s.toCharArray();
        int strLen = s.length();

        // * 前缀和
        int[] prefixSum = new int[strLen + 1];
        prefixSum[0] = s.charAt(0) == '*' ? 1 : 0;
        for (int i = 1; i < plateAndCandle.length; i++) {
            if (plateAndCandle[i] == '*') {
                prefixSum[i] = prefixSum[i - 1] + 1;
            } else {
                prefixSum[i] = prefixSum[i - 1];
            }
        }
        System.out.println(Arrays.toString(prefixSum));


        // 结点 i 左侧第一个蜡烛位置
        int[] leftCandlePos = new int[strLen];
        int lastPos = -1;
        for (int i = 0; i < plateAndCandle.length; i++) {
            if (plateAndCandle[i] == '|') {
                lastPos = i;
            }
            leftCandlePos[i] = lastPos;
        }
        System.out.println(Arrays.toString(leftCandlePos));


        lastPos = -1;
        // 结点 i 右侧第一个蜡烛位置
        int[] rightCandlePos = new int[strLen];
        for (int i = plateAndCandle.length - 1; i >= 0; i--) {
            if (plateAndCandle[i] == '|') {
                lastPos = i;
            }
            rightCandlePos[i] = lastPos;
        }
        System.out.println(Arrays.toString(rightCandlePos));


        int len = queries.length;
        int[] res = new int[len];

        int cnt = 0;
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];

            // <= 的情况为 |**| 的情况
            if (rightCandlePos[start] == -1 || leftCandlePos[end] == -1 || leftCandlePos[end] <= rightCandlePos[start]) {
                res[cnt++] = 0;
            } else {
                res[cnt++] = prefixSum[leftCandlePos[end]] - prefixSum[rightCandlePos[start]];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        //输入：s = "**|**|***|", queries = [[2,5],[5,9]]
        //输出：[2,3]
        //解释：
        //- queries[0] 有两个盘子在蜡烛之间。
        //- queries[1] 有三个盘子在蜡烛之间。
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode-cn.com/problems/plates-between-candles
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。






        Test8 test8 = new Test8();
        MyPrint.print(test8.platesBetweenCandles("**|**|***|",new int[][]{{2,5},{5,9}}));
//        try(Scanner in = new Scanner(System.in)){
//            String[] strings = new String[3];
//            for (int i = 0; i < strings.length; i++) {
//                strings[i] = in.nextLine();
//            }
//            MyPrint.print(Arrays.toString(strings) +"最大: "
//                    + Arrays.stream(strings).max(String::compareTo).get());
//        }

        //判断对称数
        StringBuilder sb1 = new StringBuilder("12329");
        StringBuilder sb2 = new StringBuilder("12329");
        sb1.reverse();
        System.out.println(sb1.toString().equals(sb2.toString()));


        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        System.out.println("天数：" + c.getActualMaximum(Calendar.DAY_OF_MONTH));

    }

}

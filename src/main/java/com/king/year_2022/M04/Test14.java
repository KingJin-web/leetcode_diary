package com.king.year_2022.M04;

import java.time.LocalDateTime;

/**
 * @program: leetcode_diary
 * @description: 1672. 最富有客户的资产总量
 * https://leetcode-cn.com/problems/richest-customer-wealth/
 * @author: King
 * @create: 2022-04-14 23:37
 */
public class Test14 {
    //
    //https://leetcode-cn.com/problems/richest-customer-wealth/solution/zui-fu-you-ke-hu-de-zichan-zong-liang-by-leetcod/
    //给你一个 m x n 的整数网格 accounts ，
    // 其中 accounts[i][j] 是第 i位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
    //客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
    //
    // 
    public int maximumWealth(int[][] accounts) {
        int MaxCount = 0;
        for(int [] account : accounts){
            int sum = 0;
            for(int i : account){
                sum += i;
            }
            MaxCount = Math.max(MaxCount,sum);
        }
        return MaxCount;
    }

    public static void main(String[] args) {
        // 此时此刻
        LocalDateTime now = LocalDateTime.now();
        // 2019-11-12T15:48:27.075098100
        System.out.println(now);
        // 明天的这个时刻
        LocalDateTime nowAtTomorrow = now.plusDays(1);
        // 2019-11-13T15:48:27.075098100
        System.out.println(nowAtTomorrow);

        int i = now.compareTo(nowAtTomorrow);
        // -1
        System.out.println(i);

        int j = nowAtTomorrow.compareTo(now);
        // 1
        System.out.println(j);
    }
}

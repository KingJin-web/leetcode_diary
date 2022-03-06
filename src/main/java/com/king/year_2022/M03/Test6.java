package com.king.year_2022.M03;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode_diary
 * @description:
 * @author: King
 * @create: 2022-03-06 23:40
 */
public class Test6 {
    //你和一群强盗准备打劫银行。给你一个下标从 0 开始的整数数组 security ，其中 security[i] 是第 i 天执勤警卫的数量。日子从 0 开始编号。同时给你一个整数 time 。
    //
    //如果第 i 天满足以下所有条件，我们称它为一个适合打劫银行的日子：
    //
    //第 i 天前和后都分别至少有 time 天。
    //第 i 天前连续 time 天警卫数目都是非递增的。
    //第 i 天后连续 time 天警卫数目都是非递减的。
    //更正式的，第 i 天是一个合适打劫银行的日子当且仅当：security[i - time] >= security[i - time + 1] >= ... >= security[i] <= ... <= security[i + time - 1] <= security[i + time].
    //
    //请你返回一个数组，包含 所有 适合打劫银行的日子（下标从 0 开始）。返回的日子可以 任意 顺序排列。

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer>res=new ArrayList<>();
        int n=security.length;
        int[]pre=new int[n+1];
        pre[0]=0;
        pre[1]=0;//递减的
        for(int i=2;i<=n;i++){
            if(security[i-1]<=security[i-2]){
                pre[i]=pre[i-1]+1;
            }
        }
        int[]aft=new int[n+1];//递减的
        aft[n]=0;
        aft[n-1]=0;
        for(int i=n-2;i>=0;i--){
            if(security[i]<=security[i+1]) aft[i]=aft[i+1]+1;

        }
        //为了让右边有time个，所以 i<n-time
        for(int i=time;i<n-time;i++){
            //i-> i-1             i->i
            if(pre[i+1]>=time&&aft[i]>=time) res.add(i);
        }
        return res;
    }
}

package com.king.year_2022.M02;

/**
 * @program: leetcode_diary
 * @description: 2016. 增量元素之间的最大差值
 * https://leetcode-cn.com/problems/maximum-difference-between-increasing-elements/
 * @author: King
 * @create: 2022-02-26 21:55
 */
public class Test25 {
    public int maximumDifference(int[] nums) {
        int sum_chazhi = 0;
        int max=0;
        for(int i=0; i<nums.length-1;i++){
            int chazhi = nums[i+1] - nums[i];
            if(sum_chazhi<=0&&chazhi>=0){
                sum_chazhi = chazhi;
                max = Math.max(chazhi, max);
            }else{
                sum_chazhi += chazhi;
                if(sum_chazhi > chazhi){
                    max = Math.max(sum_chazhi, max);
                }else{
                    max = Math.max(chazhi, max);
                }
            }
        }
        return max>0?max:-1;
    }
}

package com.king.year_2022.M04;


import java.util.Random;

/**
 * 398. 随机数索引
 */
public class Test25 {


    class Solution {

        int[]arr;
        public Solution(int[] nums) {
            arr=nums.clone();
        }
        public int pick(int target) {
            int count=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==target) count++;
            }
            int choose=new Random().nextInt(count)+1;
            count=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==target){
                    count++;
                    if(count==choose) return  i;
                }
            }
            return  -1;
        }
    }

}

package com.king.year_2022.M06;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 12613
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M06.Test16
 * @date: 2022年06月16日 21:20
 * @description: ${}
 */
public class Test16 {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        if(k<0)return count;
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }
        for(int i:map.keySet()){
            if(k==0){
                if(map.get(i)>1)
                    count++;
            }
            else if(map.containsKey(i+k)){
                count++;
            }
        }
        return count;
    }
}
package com.king.year_2022.M05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: King
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M05.Test26
 * @date: 2022年05月26日 23:48
 * @description: ${}
 */
public class Test26 {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> records = new HashMap<>();
        int n = positions.length;
        int length;
        int left;
        int right;
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            length = 0;
            left = positions[i][0];
            right = positions[i][1]+left;
            for(int j =0 ; j < i ; j++){
                if(right <= positions[j][0] || positions[j][0]+positions[j][1] <= left){
                    continue;
                }
                length = Math.max(records.get(j),length);
            }
            length += positions[i][1];
            max = Math.max(max,length);
            ans.add(max);
            records.put(i,length);
        }
        return ans;
    }
}
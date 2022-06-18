package com.king.year_2021.M08;

import com.king.util.Helper;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-08-05 23:02
 */
public class Test5 {
    /**
     * 560. ��ΪK��������
     * https://leetcode-cn.com/problems/subarray-sum-equals-k/
     */
    public static class T1 {
        private static T1 t1 = new T1();

        public int subarraySum(int[] nums, int k) {
            /**
             ɨ��һ������, ʹ��map��¼����ͬ���ĺ͵Ĵ���, ��ÿ��i�����ۼƺ�sum���ж�map���Ƿ���sum-k
             **/
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int sum = 0, ret = 0;

            for (int i = 0; i < nums.length; ++i) {
                sum += nums[i];
                if (map.containsKey(sum - k))
                    ret += map.get(sum - k);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            return ret;
        }

        public static void main(String[] args) {
            Helper.print(t1.subarraySum(Helper.getArrays(1, 1, 1), 2));
        }
    }
}

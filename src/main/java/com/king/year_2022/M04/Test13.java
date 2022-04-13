package com.king.year_2022.M04;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

/**
 * @program: leetcode_diary
 * @description: 380. O(1) 时间插入、删除和获取随机元素
 * @author: King
 * @create: 2022-04-13 23:47
 */
public class Test13 {
    class RandomizedSet {

        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        Random random = SecureRandom.getInstanceStrong();

        /** Initialize your data structure here. */
        public RandomizedSet() throws NoSuchAlgorithmException {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)){
                return false;
            }
            list.add(val);
            map.put(val,list.size()-1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            }
            int idx = map.get(val);
            int last = list.get(list.size()-1);
            list.set(idx,last);
            list.remove(list.size()-1);
            map.put(last,idx);
            map.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}

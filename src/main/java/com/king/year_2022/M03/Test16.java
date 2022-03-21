package com.king.year_2022.M03;

import java.util.*;

/**
 * @program: leetcode_diary
 * @description:
 * @author: King
 * @create: 2022-03-16 23:38
 */
public class Test16 {
    /*
@可爱抱抱呀
执行用时：53 ms, 在所有 Java 提交中击败了36.29%的用户
内存消耗：57.7 MB, 在所有 Java 提交中击败了8.11%的用户
2022年3月14日 20:58
*/
    static class AllOne {
        Map<String,Integer> map;
        TreeMap<Integer, Set<String>> freq;
        public AllOne() {
            map=new HashMap<>();
            freq=new TreeMap<>();
        }

        public void inc(String key) {
            map.put(key,map.getOrDefault(key,0)+1);
            int count=map.get(key);//目前的频率
            if(count>1){
                if(freq.get(count-1).size()==1){freq.remove(count-1);}
                else{freq.get(count-1).remove(key);}
            }
            freq.putIfAbsent(count,new HashSet<>());
            freq.get(count).add(key);
        }

        public void dec(String key) {
            int count=map.get(key);//目前的频率
            if(freq.get(count).size()==1){freq.remove(count);}
            else{freq.get(count).remove(key);}
            if(count==1){map.remove(key);}
            else{map.put(key,count-1);}
            if(count>1){
                freq.putIfAbsent(count-1,new HashSet<>());
                freq.get(count-1).add(key);
            }
        }

        public String getMaxKey() {
            if(map.size()>0){
                Integer a=freq.lastKey();
                for(String s:freq.get(a)){return s;}
            }
            return "";
        }

        public String getMinKey() {
            if(map.size()>0){
                Integer a=freq.firstKey();
                for(String s:freq.get(a)){return s;}
            }
            return "";
        }
    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
}

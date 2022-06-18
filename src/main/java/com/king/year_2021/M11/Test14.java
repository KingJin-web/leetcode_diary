package com.king.year_2021.M11;

import com.king.util.MyPrint;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 677. ��ֵӳ��
 * https://leetcode-cn.com/problems/map-sum-pairs/
 * @author: King
 * @create: 2021-11-14 12:33
 */

public class Test14 {

    //ִ����ʱ�� 12 ms , ������ Java �ύ�л����� 66.71% ���û� �ڴ����ģ� 38.3 MB , ������ Java �ύ�л����� 75.04% ���û�
    public static class MapSum {

        private Map<String, Integer> map;

        public MapSum() {
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int sum = 0;
            for (Map.Entry<String, Integer> m : map.entrySet()) {
                if (m.getKey().startsWith(prefix)) {
                    sum += m.getValue();
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        MapSum obj = new MapSum();
        obj.insert("key", 1);
        obj.insert("key2", 1);
        obj.insert("key3", 1);
        obj.insert("key", 4);
        obj.insert("123key", 1);
        int param_2 = obj.sum("key");
        MyPrint.print(obj);
        MyPrint.print(param_2);
    }

    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum obj = new MapSum();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */
}

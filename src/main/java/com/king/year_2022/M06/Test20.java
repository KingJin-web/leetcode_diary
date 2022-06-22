package com.king.year_2022.M06;

import com.king.util.MyPrint;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年06月19日 13:51
 * @description: 1108. IP 地址无效化
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/defanging-an-ip-address
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test20 {


    private static class RangeModule {
        TreeMap<Integer, Integer> intervals;

        public RangeModule() {
            intervals = new TreeMap<>();
        }

        public void addRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = intervals.higherEntry(left);
            if (entry != intervals.firstEntry()) {
                Map.Entry<Integer, Integer> start = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
                if (start != null && start.getValue() >= right) {
                    return;
                }
                if (start != null && start.getValue() >= left) {
                    left = start.getKey();
                    intervals.remove(start.getKey());
                }
            }
            while (entry != null && entry.getKey() <= right) {
                right = Math.max(right, entry.getValue());
                intervals.remove(entry.getKey());
                entry = intervals.higherEntry(entry.getKey());
            }
            intervals.put(left, right);
        }

        public boolean queryRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = intervals.higherEntry(left);
            if (entry == intervals.firstEntry()) {
                return false;
            }
            entry = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
            return entry != null && right <= entry.getValue();
        }

        public void removeRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = intervals.higherEntry(left);
            if (entry != intervals.firstEntry()) {
                Map.Entry<Integer, Integer> start = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
                if (start != null && start.getValue() >= right) {
                    int ri = start.getValue();
                    if (start.getKey() == left) {
                        intervals.remove(start.getKey());
                    } else {
                        intervals.put(start.getKey(), left);
                    }
                    if (right != ri) {
                        intervals.put(right, ri);
                    }
                    return;
                } else if (start != null && start.getValue() > left) {
                    intervals.put(start.getKey(), left);
                }
            }
            while (entry != null && entry.getKey() < right) {
                if (entry.getValue() <= right) {
                    intervals.remove(entry.getKey());
                    entry = intervals.higherEntry(entry.getKey());
                } else {
                    intervals.put(right, entry.getValue());
                    intervals.remove(entry.getKey());
                    break;
                }
            }
        }

    }


    public static void main(String[] args) {


    }

}
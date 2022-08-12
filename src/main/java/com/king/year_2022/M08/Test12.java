package com.king.year_2022.M08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年08月12日 13:55
 * @description: 1282. 用户分组
 */
public class Test12 {

    //有 n 个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID 。
    //
    //给定一个整数数组 groupSizes ，其中 groupSizes[i] 是第 i 个人所在的组的大小。例如，如果 groupSizes[1] = 3 ，则第 1 个人必须位于大小为 3 的组中。
    //
    //返回一个组列表，使每个人 i 都在一个大小为 groupSizes[i] 的组中。
    //
    //每个人应该 恰好只 出现在 一个组 中，并且每个人必须在一个组中。如果有多个答案，返回其中 任何 一个。可以 保证 给定输入 至少有一个 有效的解。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        int n = groupSizes.length;
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[groupSizes[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if (count[groupSizes[i]] == 0) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            list.add(i);
            count[groupSizes[i]]--;
            for (int j = i + 1; j < n; j++) {
                if (groupSizes[j] == groupSizes[i]) {
                    list.add(j);
                    count[groupSizes[j]]--;
                }
            }
            res.add(list);
        }
        return res;
    }

    class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            Map<Integer, List<Integer>> groups = new HashMap<Integer, List<Integer>>();
            int n = groupSizes.length;
            for (int i = 0; i < n; i++) {
                int size = groupSizes[i];
                groups.putIfAbsent(size, new ArrayList<Integer>());
                groups.get(size).add(i);
            }
            List<List<Integer>> groupList = new ArrayList<List<Integer>>();
            for (Map.Entry<Integer, List<Integer>> entry : groups.entrySet()) {
                int size = entry.getKey();
                List<Integer> people = entry.getValue();
                int groupCount = people.size() / size;
                for (int i = 0; i < groupCount; i++) {
                    List<Integer> group = new ArrayList<Integer>();
                    int start = i * size;
                    for (int j = 0; j < size; j++) {
                        group.add(people.get(start + j));
                    }
                    groupList.add(group);
                }
            }
            return groupList;
        }
    }



    public static void main(String[] args) {
        Test12 test12 = new Test12();
        List<List<Integer>> res = test12.groupThePeople(new int[]{3,3,3,3,3,1,3});
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
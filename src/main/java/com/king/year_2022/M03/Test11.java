package com.king.year_2022.M03;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode_diary
 * @description: 2049. 统计最高分的节点数目
 * @author: King
 * @create: 2022-03-11 23:21
 */
public class Test11 {
    int[] cnt;
    List<Integer>[] children;

    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        children = new List[n];
        cnt = new int[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i < n; i++) {
            children[parents[i]].add(i);
        }
        dfs(0);
        long mx = 0L;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            long cur = Math.max(1L, (long) (n - cnt[i]));
            for (int son : children[i]) {
                cur *= cnt[son];
            }
            if (cur > mx) {
                mx = cur;
                ans = 1;
            } else if (cur == mx) {
                ans++;
            }
        }
        return ans;
    }

    public void dfs(int ptr) {
        int ans = 1;
        for (int son : children[ptr]) {
            dfs(son);
            ans += cnt[son];
        }
        cnt[ptr] = ans;
    }

    public static void main(String[] args) {
        Test11 test11 = new Test11();
        MyPrint.print(test11.countHighestScoreNodes(LeetcodeUtil.stringToIntegerArray("[-1,2,0,2,0]")));
    }
}

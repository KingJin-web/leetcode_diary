package com.king.year_2022.M07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月30日 23:12
 * @description:
 */
public class Test30 {

//    public int largestComponentSize(int[] nums) {
//        int n = nums.length;
//        List[] path = new List[n + 5];
//        for (int i = 0; i < n; i++) {
//            path[i] = new ArrayList<>();
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (gcd(nums[i], nums[j]) > 1) {
//                    path[i].add(j);
//                    path[j].add(i);
//                }
//            }
//        }
//        int ans = 0;
//        boolean used[] = new boolean[n + 5];
//        for (int i = 0; i < n; i++) {
//            if (!used[i]) {
//                int count = 1;
//                used[i] = true;
//                List<Integer> list = new ArrayList<>();
//                list.add(i);
//                for (int j = 0; j < list.size(); j++) {
//                    int a = list.get(j);
//                    for (int k = 0; k < path[a].size(); k++) {
//                        int b = (int) path[a].get(k);
//                        if (!used[b]) {
//                            used[b] = true;
//                            list.add(b);
//                            count++;
//                        }
//                    }
//                }
//                ans = Math.max(ans, count);
//            }
//        }
//        return ans;
//    }
//
//    int gcd(int a, int b) {
//        return a <= b ? (b % a == 0 ? a : gcd(b % a, a)) : gcd(b, a);
//    }

    class Solution {
        public int largestComponentSize(int[] nums) {
            int m = Arrays.stream(nums).max().getAsInt();
            UnionFind uf = new UnionFind(m + 1);
            for (int num : nums) {
                for (int i = 2; i * i <= num; i++) {
                    if (num % i == 0) {
                        uf.union(num, i);
                        uf.union(num, num / i);
                    }
                }
            }
            int[] counts = new int[m + 1];
            int ans = 0;
            for (int num : nums) {
                int root = uf.find(num);
                counts[root]++;
                ans = Math.max(ans, counts[root]);
            }
            return ans;
        }
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            rank = new int[n];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx]++;
                }
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }


//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/largest-component-size-by-common-factor/solution/an-gong-yin-shu-ji-suan-zui-da-zu-jian-d-amdx/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static void main(String[] args) {
        Test30 test30 = new Test30();
        Solution solution = test30.new Solution();
        int[] nums = {4, 6, 15, 35};
        System.out.println(solution.largestComponentSize(nums));
    }
}
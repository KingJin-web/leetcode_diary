package com.king.year_2022.M01;

import com.king.util.MyPrint;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode_diary
 * @description: 2013. 检测正方形
 * https://leetcode-cn.com/problems/detect-squares/
 * @author: King
 * @create: 2022-01-26 22:00
 */
public class Test26 {
    private static class DetectSquares {
        Map<Integer, Map<Integer, Integer>> xMap = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> yMap = new HashMap<>();

        public DetectSquares() {

        }

        public void add(int[] point) {
            Map<Integer, Integer> x = xMap.getOrDefault(point[0], new HashMap<>());
            x.put(point[1], x.getOrDefault(point[1], 0) + 1);
            xMap.put(point[0], x);
            Map<Integer, Integer> y = yMap.getOrDefault(point[1], new HashMap<>());
            y.put(point[0], y.getOrDefault(point[0], 0) + 1);
            yMap.put(point[1], y);
        }

        public int count(int[] point) {
            int x = point[0], y = point[1];
            int ans = 0;
            // find a point b(x + ?, y)
            if (!yMap.containsKey(y)) return 0;
            Map<Integer, Integer> sameY = yMap.get(y);
            // iterating all b points
            for (int bX : sameY.keySet()) {
                int bCount = sameY.get(bX);
                int d = bX - x;
                if (d != 0) {
                    // find c
                    if (!xMap.containsKey(x)) continue;
                    Map<Integer, Integer> sameX = xMap.get(x);
                    if (sameX.containsKey(y - d)) {
                        // find d
                        if (xMap.get(bX) != null && xMap.get(bX).containsKey(y - d)) {
                            int cCount = sameX.get(y - d);
                            int dCount = xMap.get(bX).get(y - d);
                            ans += cCount * dCount * bCount;
                        }
                    }
                    if (sameX.containsKey(y + d)) {
                        // find d
                        if (xMap.get(bX) != null && xMap.get(bX).containsKey(y + d)) {
                            int cCount = sameX.get(y + d);
                            int dCount = xMap.get(bX).get(y + d);
                            ans += cCount * dCount * bCount;
                        }
                    }
                }
            }
            return ans;
        }
    }

    //输入：
    //["DetectSquares", "add", "add", "add", "count", "count", "add", "count"]
    //[[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 10]]]
    //输出：
    //[null, null, null, null, 1, 0, null, 2]
    //
    //解释：
    //DetectSquares detectSquares = new DetectSquares();
    //detectSquares.add([3, 10]);
    //detectSquares.add([11, 2]);
    //detectSquares.add([3, 2]);
    //detectSquares.count([11, 10]); // 返回 1 。你可以选择：
    //                               //   - 第一个，第二个，和第三个点
    //detectSquares.count([14, 8]);  // 返回 0 。查询点无法与数据结构中的这些点构成正方形。
    //detectSquares.add([11, 2]);    // 允许添加重复的点。
    //detectSquares.count([11, 10]); // 返回 2 。你可以选择：
    //                               //   - 第一个，第二个，和第三个点
    //                               //   - 第一个，第三个，和第四个点
    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();

        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        int a = detectSquares.count(new int[]{11, 10}); // 返回 1 。你可以选择：
        //   - 第一个，第二个，和第三个点
        int b = detectSquares.count(new int[]{14, 8});  // 返回 0 。查询点无法与数据结构中的这些点构成正方形。
        detectSquares.add(new int[]{11, 2});    // 允许添加重复的点。
        int c = detectSquares.count(new int[]{11, 10}); // 返回 2 。你可以选择：
        MyPrint.printObs(a,b,c);
    }
}

package com.king.year_2022.M02;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode_diary
 * @description: 969. 煎饼排序
 * https://leetcode-cn.com/problems/pancake-sorting/
 * @author: King
 * @create: 2022-02-19 11:59
 */
public class Test19 {

    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        int[] idxs = new int[n + 10];
        for (int i = 0; i < n; i++) idxs[arr[i]] = i;
        List<Integer> ans = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            int idx = idxs[i];
            if (idx == i - 1) continue;
            if (idx != 0) {
                ans.add(idx + 1);
                reverse(arr, 0, idx, idxs);
            }
            ans.add(i);
            reverse(arr, 0, i - 1, idxs);
        }
        return ans;
    }

    void reverse(int[] arr, int i, int j, int[] idxs) {
        while (i < j) {
            idxs[arr[i]] = j;
            idxs[arr[j]] = i;
            int c = arr[i];
            arr[i++] = arr[j];
            arr[j--] = c;
        }
    }

    public static void main(String[] args) {
        //输入：[3,2,4,1]
        //输出：[4,2,4,3]
        //解释：
        //我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
        //初始状态 arr = [3, 2, 4, 1]
        //第一次翻转后（k = 4）：arr = [1, 4, 2, 3]
        //第二次翻转后（k = 2）：arr = [4, 1, 2, 3]
        //第三次翻转后（k = 4）：arr = [3, 2, 1, 4]
        //第四次翻转后（k = 3）：arr = [1, 2, 3, 4]，此时已完成排序。
        Test19 test19 = new Test19();
        MyPrint.print(test19.pancakeSort(LeetcodeUtil.stringToIntegerArray("[3,2,4,1]")));
    }
}

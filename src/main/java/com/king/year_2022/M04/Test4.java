package com.king.year_2022.M04;

import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode_diary
 * @description: 307. 区域和检索 - 数组可修改
 * @author: King
 * @create: 2022-04-04 22:44
 */
public class Test4 {
    //超时了
    public static class NumArray1 {
        private final int[] nums;

        public NumArray1(int[] nums) {
            this.nums = nums;
        }

        public void update(int i, int val) {
            nums[i] = val;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum += nums[k];
            }
            return sum;
        }
    }

    //超时了
    private static class NumArray2 {

        private final List<Integer> nums;

        public NumArray2(int[] nums) {
            //数组转换为list
            this.nums = Arrays.stream(nums).boxed().collect(java.util.stream.Collectors.toList());
        }

        public void update(int i, int val) {
            nums.set(i, val);
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum += nums.get(k);
            }
            return sum;
        }
    }

   private static class NumArray {
        private int[] sum; // sum[i] 表示第 i 个块的元素和
        private int size; // 块的大小
        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            int n = nums.length;
            size = (int) Math.sqrt(n);
            sum = new int[(n + size - 1) / size]; // n/size 向上取整
            for (int i = 0; i < n; i++) {
                sum[i / size] += nums[i];
            }
        }

        public void update(int index, int val) {
            sum[index / size] += val - nums[index];
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            int b1 = left / size, i1 = left % size, b2 = right / size, i2 = right % size;
            if (b1 == b2) { // 区间 [left, right] 在同一块中
                int sum = 0;
                for (int j = i1; j <= i2; j++) {
                    sum += nums[b1 * size + j];
                }
                return sum;
            }
            int sum1 = 0;
            for (int j = i1; j < size; j++) {
                sum1 += nums[b1 * size + j];
            }
            int sum2 = 0;
            for (int j = 0; j <= i2; j++) {
                sum2 += nums[b2 * size + j];
            }
            int sum3 = 0;
            for (int j = b1 + 1; j < b2; j++) {
                sum3 += sum[j];
            }
            return sum1 + sum2 + sum3;
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 5};
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(0, 2);
        obj.update(1, 2);
        int param_2 = obj.sumRange(0, 2);
        System.out.println(param_1);
        System.out.println(param_2);
    }
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

}

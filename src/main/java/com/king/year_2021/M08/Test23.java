package com.king.year_2021.M08;

/**
 * @program: leetcode
 * @description: 1646. ��ȡ���������е����ֵ
 * https://leetcode-cn.com/problems/get-maximum-in-generated-array/
 * @author: King
 * @create: 2021-08-23 10:23
 */
public class Test23 {

    /**
     * ����һ������ n ����������������һ������Ϊ n + 1 ������ nums ��
     * <p>
     * nums[0] = 0
     * nums[1] = 1
     * �� 2 <= 2 * i <= n ʱ��nums[2 * i] = nums[i]
     * �� 2 <= 2 * i + 1 <= n ʱ��nums[2 * i + 1] = nums[i] + nums[i + 1]
     * ������������ nums �е� ��� ֵ��
     *
     * @param n
     * @return
     */
    public int GetMaximumGenerated(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 0;
        for (int i = 2; i <= n; ++i) {
            int k = nums[i] = (i & 1) == 0 ? nums[i >> 1] : nums[i >> 1] + nums[(i >> 1) + 1];
            if (k > max) max = k;
        }
        return max;
    }

    public static void main(String[] args) {
        Test23 test23 = new Test23();

        
    }

}

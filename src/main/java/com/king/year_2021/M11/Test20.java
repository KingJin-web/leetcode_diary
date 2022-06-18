package com.king.year_2021.M11;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 594. ���г������
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-harmonious-subsequence
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-11-20 23:17
 */
public class Test20 {

    //��г������ָһ��������Ԫ�ص����ֵ����Сֵ֮��Ĳ�� ������ 1 ��
    //
    //���ڣ�����һ���������� nums �����������п��ܵ����������ҵ���ĺ�г�����еĳ��ȡ�
    //
    //�������������һ���������������������У�������ͨ��ɾ��һЩԪ�ػ�ɾ��Ԫ�ء��Ҳ��ı�����Ԫ�ص�˳����õ���


    public int findLHS1(int[] nums) {
        Arrays.sort(nums);
        int begin = 0, res = 0;
        for (int end = 0; end < nums.length; end++) {
            while (nums[end] - nums[begin] > 1)
                begin++;
            if (nums[end] - nums[begin] == 1)
                res = Math.max(res, end - begin + 1);
        }
        return res;
    }

    //ִ����ʱ�� 18 ms , ������ Java �ύ�л����� 43.71% ���û� �ڴ����ģ� 40.1 MB , ������ Java �ύ�л����� 5.89% ���û�
    public int findLHS2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for(int num : map.keySet()){
            if(map.containsKey(num - 1))
                res = Math.max(res, map.get(num - 1) + map.get(num));
            if(map.containsKey(num + 1))
                res = Math.max(res, map.get(num + 1) + map.get(num));
        }
        return res;

    }
    public int findLHS(int[] nums) {
        HashMap <Integer, Integer> cnt = new HashMap <>();
        int res = 0;
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        for (int key : cnt.keySet()) {
            if (cnt.containsKey(key + 1)) {
                res = Math.max(res, cnt.get(key) + cnt.get(key + 1));
            }
        }
        return res;

    }
    public static void main(String[] args) {
        //���룺nums = [1,3,2,2,5,2,3,7]
        //�����5
        //���ͣ���ĺ�г�������� [3,2,2,2,3]

        Test20 test20 = new Test20();
        int a = test20.findLHS(LeetcodeUtil.stringToIntegerArray("[1,3,2,2,5,2,3,7]"));
        MyPrint.print(a);

        short aa = -20;

        int x = 2, y = 4;
        System.out.println(++x != y--);
    }
}

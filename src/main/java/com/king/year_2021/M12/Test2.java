package com.king.year_2021.M12;


import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: 506. �������
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/relative-ranks
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-12-02 02:30
 */
public class Test2 {
    //����һ������Ϊ n ���������� score ������ score[i] �ǵ� i λ�˶�Ա�ڱ����еĵ÷֡����е÷ֶ� ������ͬ ��
    //
    //�˶�Ա�����ݵ÷� �������� ���������ε� 1 ���˶�Ա�÷���ߣ����ε� 2 ���˶�Ա�÷ֵ� 2 �ߣ�
    // �������ơ��˶�Ա�����ξ��������ǵĻ������
    //
    //���ε� 1 ���˶�Ա����� "Gold Medal" ��
    //���ε� 2 ���˶�Ա������ "Silver Medal" ��
    //���ε� 3 ���˶�Ա��ͭ�� "Bronze Medal" ��
    //�����ε� 4 ���� n ���˶�Ա��ֻ�ܻ�����ǵ����α�ţ��������ε� x ���˶�Ա��ñ�� "x"����
    //ʹ�ó���Ϊ n ������ answer ���ػ񽱣����� answer[i] �ǵ� i λ�˶�Ա�Ļ������

    public String[] findRelativeRanks1(int[] score) {
        int n = score.length;
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i) {
            if (i >= 3) {
                ans[arr[i][1]] = Integer.toString(i + 1);
            } else {
                ans[arr[i][1]] = desc[i];
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        //���룺score = [5,4,3,2,1]
        //�����["Gold Medal","Silver Medal","Bronze Medal","4","5"]
        //���ͣ�����Ϊ [1st, 2nd, 3rd, 4th, 5th] ��
        Test2 test2 = new Test2();
        MyPrint.print(test2.findRelativeRanks(LeetcodeUtil.stringToIntegerArray("[5,4,3,2,1]")));
        //["Gold Medal","5","Bronze Medal","Silver Medal","4"]
        MyPrint.print(test2.findRelativeRanks(LeetcodeUtil.stringToIntegerArray("[10,3,8,9,4]")));
    }

    //ִ����ʱ�� 177 ms , ������ Java �ύ�л����� 5.07% ���û� �ڴ����ģ� 39.4 MB , ������ Java �ύ�л����� 68.51% ���û�
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        sort(nums,n);
        String[] strings = new String[n];

//        MyPrint.print(list);
//        MyPrint.print(nums);
        for (int i = 0; i < n; i++) {
            if (i < 3){
                strings[list.indexOf(nums[i])] = desc[i];
            }else {
                strings[list.indexOf(nums[i])] = Integer.toString(i + 1);
            }
        }

        return strings;
    }

    public void sort(int[] arr,int n) {
        int temp;//����һ����ʱ����
        for (int i = 0; i <n - 1; ++i) {//ð������
            for (int j = 0; j < n - i - 1; ++j) {
                if (arr[j + 1] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}

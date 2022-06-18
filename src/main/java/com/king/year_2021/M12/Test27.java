package com.king.year_2021.M12;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 825. ���������
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/friends-of-appropriate-ages
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-12-27 23:18
 */
public class Test27 {
    //825. ���������
    //���罻ý����վ���� n ���û�������һ���������� ages ������ ages[i] �ǵ� i ���û������䡣
    //
    //�����������һ������Ϊ�棬��ô�û� x ���������û� y��x != y�����ͺ�������
    //
    //age[y] <= 0.5 * age[x] + 7
    //age[y] > age[x]
    //age[y] > 100 && age[x] < 100
    //����x ������ y ����һ����������
    //
    //ע�⣬��� x �� y ����һ����������y ����Ҳ�� x ����һ�������������⣬�û��������Լ����ͺ�������
    //
    //�����ڸ��罻ý����վ�ϲ����ĺ�������������

    public int numFriendRequests1(int[] ages) {
        int n = ages.length;
        Arrays.sort(ages);
        int left = 0, right = 0, ans = 0;
        for (int age : ages) {
            if (age < 15) {
                continue;
            }
            while (ages[left] <= 0.5 * age + 7) {
                ++left;
            }
            while (right + 1 < n && ages[right + 1] <= age) {
                ++right;
            }
            ans += right - left;
        }
        return ans;
    }

    //ʾ�� 1��
    //
    //���룺ages = [16,16]
    //�����2
    //���ͣ�2 �˻�����������
    //ʾ�� 2��
    //
    //���룺ages = [16,17,18]
    //�����2
    //���ͣ������ĺ�������Ϊ 17 -> 16 ��18 -> 17 ��
    //ʾ�� 3��
    //
    //���룺ages = [20,30,100,110,120]
    //�����3
    //���ͣ������ĺ�������Ϊ 110 -> 100 ��120 -> 110 ��120 -> 100 ��
    //?
    //
    public static void main(String[] args) {
        Test27 test = new Test27();
        MyPrint.print(test.numFriendRequests1(LeetcodeUtil.stringToIntegerArray("[20,30,100,110,120]")));
    }
}

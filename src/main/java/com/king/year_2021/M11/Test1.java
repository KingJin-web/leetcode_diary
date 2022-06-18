package com.king.year_2021.M11;

import com.king.util.Helper;
import com.king.util.MyPrint;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 575. ���ǹ�
 * https://leetcode-cn.com/problems/distribute-candies/
 * @author: King
 * @create: 2021-11-01 04:09
 */
public class Test1 {

    //����һ��ż�����ȵ����飬���в�ͬ�����ִ����Ų�ͬ������ǹ���ÿһ�����ִ���һ���ǹ���
    // ����Ҫ����Щ�ǹ�ƽ���ָ�һ���ܵܺ�һ�����á��������ÿ��Ի�õ�����ǹ�����������

    /**
     * ̰��
     * �������⣬����ÿ���ǹ�����Ҫ��һ��1.
     * 1. ����ǹ�������<=���鳤�ȵ�һ�룬��ô���ÿ����õ�����������ǹ���ans = �ǹ�������
     * 2. ����ǹ�������>���鳤�ȵ�һ�룬��ô�������õ��������ǹ���������ͬ��ans = candyType.length/2
     * ����ȡС���ɡ�
     */

    //ִ����ʱ�� 36 ms , ������ Java �ύ�л����� 42.44% ���û� �ڴ����ģ� 40 MB , ������ Java �ύ�л����� 93.15% ���û�
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int num : candyType) {
            set.add(num);
        }
        return Math.min(set.size(), candyType.length>>1);
     //   return set.size() <= candyType.length / 2 ? ln : ln / 2;
    }

    //����: candies = [1,1,2,2,3,3]
    //���: 3
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        MyPrint.print(test1.distributeCandies(Helper.getArrays(1,1,2,2,3,3)));
    }
}

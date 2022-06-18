package com.king.year_2021.M08;

import com.king.util.Helper;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 881. ����ͧ
 * https://leetcode-cn.com/problems/boats-to-save-people/
 * @author: King
 * @create: 2021-08-26 22:50
 */
public class Test26 {
    /**
     * ��i���˵�����Ϊpeople[i]��ÿ�Ҵ����Գ��ص��������Ϊlimit��
     * ÿ�Ҵ�����ͬʱ�����ˣ�����������Щ�˵�����֮�����Ϊlimit��
     * �����ص�ÿһ�����������С������(��֤ÿ���˶��ܱ�����)��
     * <p>
     * ִ����ʱ�� 16 ms , ������ Java �ύ�л����� 95.52% ���û�
     * �ڴ����ģ� 47.4 MB , ������ Java �ύ�л����� 24.52% ���û�
     *
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int right = people.length - 1;
        int left = 0;
        while (left <= right) {
            if (left == right) {
                ++count;
                break;
            }
            if (people[left] + people[right] > limit) {
                ++count;
                --right;        // �������ص�, ������С��Ҳ�޷�һ����,��ô�����صĵ�����
            } else {
                ++count;
                --right;        // ���ص��������һ����
                ++left;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Test26 test26 = new Test26();
        Helper.print(test26.numRescueBoats(Helper.getArrays(3, 2, 2, 1), 3));//3
        Helper.print(test26.numRescueBoats(Helper.getArrays(3, 5, 3, 4), 5));//4
        Helper.print(test26.numRescueBoats(Helper.getArrays(5, 1, 4, 2), 6));//2
    }
}

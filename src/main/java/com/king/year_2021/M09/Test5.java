package com.king.year_2021.M09;

import com.king.util.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: leetcode
 * @description: 470. �� Rand7() ʵ�� Rand10()
 * //��Դ�����ۣ�LeetCode��
 * //���ӣ�https://leetcode-cn.com/problems/implement-rand10-using-rand7
 * //����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-09-05 23:37
 */
public class Test5 {
    //���з���rand7������ 1 �� 7 ��Χ�ڵľ��������������дһ������?rand10���� 1 �� 10 ��Χ�ڵľ������������
    //��Ҫʹ��ϵͳ��Math.random()������
    private static class T1 {
        public int rand10() {
            int ans = rand2();
            for (int i = 0; i < 3; i++) {
                ans <<= 1;
                ans ^= rand2();
            }
            return (ans <= 10 && ans > 0) ? ans : rand10();
        }

        public int rand2() {
            int ans = rand7();
            return ans == 7 ? rand2() : ans % 2;
        }

        private int rand7() {
            Random random = new Random();
            return random.nextInt(7) + 1;
        }
    }

    //ִ����ʱ�� 19 ms , ������ Java �ύ�л����� 10.62% ���û� �ڴ����ģ� 43.6 MB , ������ Java �ύ�л����� 11.46% ���û�
    public int rand10() {
        return (rand7() + rand7() + rand7() + rand7() + rand7() + rand7() + rand7() + rand7() + rand7() + rand7()) % 10 + 1;
    }

    private final Random random = new Random();

    private int rand7() {

        return random.nextInt(7) + 1;
    }

    public static void main(String[] args) {

        Test5 test5 = new Test5();
        T1 t1 = new T1();
        List<Integer> list = new ArrayList<>();
        while (list.size() < 1000) {
            list.add(test5.rand10());
        }
        Helper.print(list.toArray(), 5);
    }


}

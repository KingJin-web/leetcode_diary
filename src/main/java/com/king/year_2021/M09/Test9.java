package com.king.year_2021.M09;

import com.king.util.MyPrint;
import com.king.util.LeetcodeUtil;

/**
 * @program: leetcode
 * @description: 1894. �ҵ���Ҫ����۱ʵ�ѧ�����
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-09-10 18:42
 */
public class Test9 {
//һ���༶����n��ѧ�������Ϊ 0�� n - 1��ÿ��ѧ�������λش����⣬���Ϊ 0��ѧ���Ȼش�
//Ȼ���Ǳ��Ϊ 1��ѧ�����Դ����ƣ�ֱ�����Ϊ n - 1��ѧ����Ȼ����ʦ���ظ�������̣����´ӱ��Ϊ 0��ѧ����ʼ�ش����⡣
//����һ������Ϊ n���±�� 0��ʼ����������chalk��һ������k��һ��ʼ�۱ʺ����ܹ���k֧�۱ʡ������Ϊi��ѧ���ش�����ʱ��
//�������� chalk[i]֧�۱ʡ����ʣ��۱����� �ϸ�С��chalk[i]����ôѧ�� i��Ҫ ����۱ʡ�
//���㷵����Ҫ ����۱ʵ�ѧ�� ��š�

    //ִ����ʱ�� 2537 ms , ������ Java �ύ�л����� 5.03% ���û� �ڴ����ģ� 54.5 MB , ������ Java �ύ�л����� 27.96% ���û�
    public int chalkReplacer1(int[] chalk, int k) {
        while (true) {
            for (int i = 0; i < chalk.length; i++) {
                if (k < chalk[i]) {
                    return i;
                }
                k -= chalk[i];
            }
        }
    }

    //��ʱ
    public int chalkReplacer(int[] chalk, int k) {
        int index = 0;
        int ln = chalk.length;
        int a = 0;
        while (k >= (a = chalk[index % ln])) {
            k -= a;
            System.out.println("  " + index % ln + " " + k);
            ++index;
        }
        return index % ln;
    }

    public static void main(String[] args) {
        //���룺chalk = [5,1,5], k = 22
        //�����0
        //���ͣ�ѧ�����ķ۱�������£�
        //- ���Ϊ 0 ��ѧ��ʹ�� 5 ֧�۱ʣ�Ȼ�� k = 17 ��
        //- ���Ϊ 1 ��ѧ��ʹ�� 1 ֧�۱ʣ�Ȼ�� k = 16 ��
        //- ���Ϊ 2 ��ѧ��ʹ�� 5 ֧�۱ʣ�Ȼ�� k = 11 ��
        //- ���Ϊ 0 ��ѧ��ʹ�� 5 ֧�۱ʣ�Ȼ�� k = 6 ��
        //- ���Ϊ 1 ��ѧ��ʹ�� 1 ֧�۱ʣ�Ȼ�� k = 5 ��
        //- ���Ϊ 2 ��ѧ��ʹ�� 5 ֧�۱ʣ�Ȼ�� k = 0 ��
        //���Ϊ 0 ��ѧ��û���㹻�ķ۱ʣ���������Ҫ����۱ʡ�
        Test9 test9 = new Test9();
        MyPrint.print(test9.chalkReplacer(LeetcodeUtil.stringToIntegerArray("[5,1,5]"), 22));
        MyPrint.print(test9.chalkReplacer(LeetcodeUtil.stringToIntegerArray("[3,4,1,2]"), 25));
    }
}

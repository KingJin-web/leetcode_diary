package com.king.year_2021.M11;

import com.king.util.MyPrint;
import org.junit.rules.TestRule;

/**
 * @program: leetcode
 * @description: 367. ��Ч����ȫƽ����
 * @author: King
 * @create: 2021-11-04 00:57
 */
public class Test4 {

    //����һ�� ������ num ����дһ����������� num ��һ����ȫƽ�������򷵻� true �����򷵻� false ��
    //
    //���ף���Ҫ ʹ���κ����õĿ⺯������? sqrt ��
    //
    //��Դ�����ۣ�LeetCode��
    //���ӣ�https://leetcode-cn.com/problems/valid-perfect-square
    //����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������

    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 35.3 MB , ������ Java �ύ�л����� 26.79% ���û�
    public boolean isPerfectSquare(int num) {
        return Math.sqrt(num) % 1 == 0;
    }

    public boolean isPerfectSquare1(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // int product = mid * mid;   Խ��
            int t = num / mid;
            if (t == mid) {
                if (num%mid == 0) return true;
                low = mid + 1;
            } else if (t < mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        MyPrint.print(test4.isPerfectSquare(16));
    }
}

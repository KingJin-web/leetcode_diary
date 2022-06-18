package com.king.year_2021.M11;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: leetcode
 * @description: 786. �� K ����С����������
 * https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/
 * @author: King
 * @create: 2021-11-29 23:09
 */
public class Test29 {

    //ִ����ʱ�� 379 ms , ������ Java �ύ�л����� 28.24% ���û� �ڴ����ģ� 74.6 MB , ������ Java �ύ�л����� 21.18% ���û�



     int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        List<int[]> frac = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                frac.add(new int[]{arr[i], arr[j]});
            }
        }
        frac.sort((x, y) -> x[0] * y[1] - y[0] * x[1]);
        return frac.get(k - 1);
    }

    public static void main(String[] args) {
        //���룺arr = [1,2,3,5], k = 3
        //�����[2,5]
        //���ͣ��ѹ���õķ���,�����������ʾ:
        //1/5, 1/3, 2/5, 1/2, 3/5, 2/3
        //�����Ե�������С�ķ����� 2/5
     Test29 test29 = new Test29();
        MyPrint.print(test29.kthSmallestPrimeFraction(LeetcodeUtil.stringToIntegerArray("[1,2,3,5]"),3));

    }


}



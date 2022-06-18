package com.king.year_2021.contest.problems.OneDay;


import com.king.util.MyPrint;
import com.king.year_2021.Helper;

/**
 * @program: leetcode
 * @description: LCP 33. ��ˮ
 * ���ӣ�https://leetcode-cn.com/problems/o8SXZn
 * ��Դ�����ۣ�LeetCode��
 * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-09-16 20:32
 */
public class Test3 {

    public int storeWater(int[] bucket, int[] vat) {
        int maxVat = 0;
        for (int v : vat) maxVat = Math.max(v, maxVat);
        if (maxVat == 0) return 0; //�������Ϊ0����������ˮ��ֱ�ӷ���0
        int ans = 10001;
        for (int pour = 1; pour <= 10000; pour++) { //ö�ٵ�ˮ����1-10000
            if (pour >= ans) break;
            int upgrade = 0;
            for (int i = 0; i < vat.length; i++) { //ö��ÿ��ˮͰ����������������
                int cur = (int) Math.ceil((double) vat[i] / pour - bucket[i]); //����/��ˮ����-��ʼ��ˮ��=��������
                upgrade += Math.max(cur, 0);
                if (upgrade >= ans) break;
            }
            ans = Math.min(ans, upgrade + pour); //��ˮ���� + ���������� = �ܴ���
        }
        return ans;
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
//        ���룺bucket = [1,3], vat = [6,8]
//        �����4
        MyPrint.print(test3.storeWater(Helper.getArrays(1,3),Helper.getArrays(6,8)));
    }


}

package com.king.year_2021.M12;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 1518. ��������
 * //��Դ�����ۣ�LeetCode��
 * //���ӣ�https://leetcode-cn.com/problems/water-bottles
 * //����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-12-17 23:31
 */
public class Test17 {

    //С�����������ڴ������� numExchange ���վ�ƿ���Զһ�һƿ�¾ơ��㹺���� numBottles ƿ�ơ�
    //����ȵ��˾�ƿ�еľƣ���ô��ƿ�ͻ��ɿյġ�
    //������� ��� �ܺȵ�����ƿ�ơ�


    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 35.2 MB , ������ Java �ύ�л����� 44.68% ���û�
    public int numWaterBottles(int numBottles, int numExchange) {
        int bottle = numBottles, ans = numBottles;
        while (bottle >= numExchange) {
            bottle -= numExchange;
            ++ans;
            ++bottle;
        }
        return ans;
    }


    public static void main(String[] args) {
        Test17 test17 = new Test17();
        MyPrint.print(test17.numWaterBottles(9,3));

    }
}

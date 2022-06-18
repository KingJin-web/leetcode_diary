package com.king.year_2021.M11;

import com.king.util.MyPrint;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 319. ���ݿ���
 * @author: King
 * @create: 2021-11-15 00:46
 */
public class Test15 {
//��ʼʱ��?n �����ݴ��ڹر�״̬����һ�֣��㽫������е��ݡ��������ĵڶ��֣��㽫��ÿ�������ݹر�һ����
//
//�����֣���ÿ�������ݾ��л�һ�����ݵĿ��أ������򿪱�رգ��رձ�򿪣����� i �֣���ÿ i �����ݾ��л�һ�����ݵĿ��ء�ֱ���� n �֣���ֻ��Ҫ�л����һ�����ݵĿ��ء�
//
//�ҳ������� n?�ֺ��ж��ٸ����ŵĵ��ݡ�
//
//��Դ�����ۣ�LeetCode��
//���ӣ�https://leetcode-cn.com/problems/bulb-switcher
//����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
    /**
     * ��ʼ��n�����ݹر�
     * ��i�ֵĲ�����ÿi�������л�һ�ο��أ���->�գ���->���������л�i�ı���λ�õĿ��ء�
     * ��n�ֺ����ŵĵ��ݣ�
     * ��1����i��ʱ�����л��ĵ���λ����i�ı�����
     * ��2���ɣ�1���ó������ڵ�p��������˵��ֻ����ڡ����ӡ��ֲŻ��л���������q�����ӣ������ձ��л�q�Ρ���Ϊ��ʼ״̬�ǹر�״̬����ô�������������ĵ������������ŵġ�
     * ��3��ֻ��ƽ���������Ӹ������ǳɶԳ��֣�������4=1*4,2*2����������1,2,4��
     * ��4����ô��Ŀ����ת��Ϊ1~n��ƽ�����ĸ���������ת��Ϊ��n��ƽ����������ȡ�����ɡ�
     */

    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 34.8 MB , ������ Java �ύ�л����� 96.95% ���û�
    public int bulbSwitch(int n) {
        return (int) Math.floor(Math.sqrt(n));
    }


    public static void main(String[] args) {
        Test15 test15 = new Test15();
        MyPrint.print(test15.bulbSwitch(3));
    }
}
class Solution {
    public boolean isRectangleCover(int[][] r) {
        //ֻ��4�������γ��ֵ�����/
        // ������
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int top = Integer.MIN_VALUE;
        int bottom = Integer.MAX_VALUE;
        int n = r.length;

        Set<String> set = new HashSet<>();
        int sum = 0; // С�������
        for(int i  =  0; i < n; i++){
            int []t = r[i];
            //���´�����ĸ�������
            left = Math.min(left, t[0]);
            bottom = Math.min(bottom, t[1]);
            right = Math.max(right, t[2]);
            top = Math.max(top, t[3]);
            //����С�������
            sum += (caculateArea(t[0], t[1], t[2], t[3]));
            //��¼����
            String [] strings = new String[4];
            // С�����ĸ�������
            strings[0] = merge(t[0], t[1]);
            strings[1] = merge(t[0], t[3]);
            strings[2] = merge(t[2], t[1]);
            strings[3] = merge(t[2], t[3]);
            // ����ż���εĵ����������α���
            for(int j = 0; j < 4; j++){
                if(set.contains(strings[j]))set.remove(strings[j]);
                else set.add(strings[j]);
            }
        }
        //������ֻʣ4���㲢��set�е�4����������4���������Ӧ�ű�ʾλ��ƥ��
        if(set.size() == 4 &&
                set.contains(merge(left, top)) &&
                set.contains(merge(left, bottom)) &&
                set.contains(merge(right, top))&&
                set.contains(merge(right, bottom))
        ){
            return sum == caculateArea(left, bottom, right, top);// �����ȼ���
        }
        return false;
    }
    int caculateArea(int left, int bottom, int right, int top){
        return (top - bottom) * (right - left);
    }
    String merge(int a, int b){
        return a + " " + b;
    }
}


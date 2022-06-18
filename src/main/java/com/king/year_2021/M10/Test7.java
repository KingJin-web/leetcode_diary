package com.king.year_2021.M10;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 434. �ַ����еĵ�����
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-10-07 09:21
 */
public class Test7 {

    //ͳ���ַ����еĵ��ʸ���������ĵ���ָ���������Ĳ��ǿո���ַ���
    //��ע�⣬����Լٶ��ַ����ﲻ�����κβ��ɴ�ӡ���ַ���
    //ʾ��:
    //
    //����: "Hello, my name is John"
    //���: 5
    //����: ����ĵ�����ָ�����Ĳ��ǿո���ַ������� "Hello," ���� 1 �����ʡ�


    //ִ����ʱ�� 2 ms , ������ Java �ύ�л����� 28.55% ���û� �ڴ����ģ� 36.4 MB , ������ Java �ύ�л����� 19.91% ���û�
    public int countSegments(String s) {
        if(s.equals("")) return 0;
        int k=0;
        for(int i=0;i<s.length();i++){
            if(!Character.isSpace(s.charAt(i))){
                k=i;
                break;
            }

        }
        String str = s.substring(k);
        String[] arr = str.split("\\s+");
        return arr.length;
    }

    public static void main(String[] args) {
        Test7 test7 = new Test7();
        MyPrint.print(test7.countSegments("Hello, my name is John"));
        MyPrint.print(test7.countSegments(""));
        MyPrint.print(test7.countSegments(", , , ,        a, eaefa"));//6
    }
}


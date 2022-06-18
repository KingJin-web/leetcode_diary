package com.king.year_2021.M12;

import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 1078. Bigram �ִ�
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/occurrences-after-bigram
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-12-26 02:22
 */
public class Test26 {
    //������һ����first �͵ڶ�����second��������ĳЩ�ı�text�п����� "first second third" ��ʽ���ֵ������
    // ����second����first���֣�third����second���֡�
    //
    //����ÿ����������������������� "third" ��ӵ����У������ش𰸡�

    //ʾ�� 1��
    //
    //���룺text = "alice is a good girl she is a good student", first = "a", second = "good"
    //�����["girl","student"]
    //ʾ�� 2��
    //
    //���룺text = "we will we will rock you", first = "we", second = "will"
    //�����["we","rock"]


    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 36.4 MB , ������ Java �ύ�л����� 73.00% ���û�
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] strings = text.split(" ");
        for (int i = 0; i < strings.length - 2; i++) {
            if (strings[i].equals(first)) {
                if (strings[i + 1].equals(second)) {
                    list.add(strings[i + 2]);
                }
            }
        }
        return list.toArray(new String[0]);

    }

    public static void main(String[] args) {
        Test26 text = new Test26();
        MyPrint.print(text.findOcurrences("alice is a good girl she is a good student", "a", "good"));

    }
}

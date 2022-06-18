package com.king.year_2021.M09;

import com.king.util.MyPrint;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: leetcode
 * @description: 678. ��Ч�������ַ���
 * https://leetcode-cn.com/problems/valid-parenthesis-string/
 * @author: King
 * @create: 2021-09-12 20:54
 */
public class Test11 {
    //ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 52.53% ���û� �ڴ����ģ� 36.2 MB , ������ Java �ύ�л����� 74.51% ���û�
    public boolean checkValidString(String s) {
        Deque<Integer> leftStack = new LinkedList<Integer>();
        Deque<Integer> asteriskStack = new LinkedList<Integer>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftStack.push(i);
            } else if (c == '*') {
                asteriskStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    return false;
                }
            }
        }
        while (!leftStack.isEmpty() && !asteriskStack.isEmpty()) {
            int leftIndex = leftStack.pop();
            int asteriskIndex = asteriskStack.pop();
            if (leftIndex > asteriskIndex) {
                return false;
            }
        }
        return leftStack.isEmpty();
    }

    public static void main(String[] args) {
        Test11 test11 = new Test11();

        MyPrint.print(test11.checkValidString("(*))"));
    }

    public void a( Integer[] cards) {

        Arrays.sort(cards, Collections.reverseOrder());
        Arrays.sort(cards, Collections.reverseOrder());
        Arrays.sort(cards, (Integer a, Integer b) -> {
            return b - a;
        });
        Arrays.sort(cards, (o1, o2) -> o2 - o1);
    }


    //����һ��ֻ���������ַ����ַ�������?����?�� *��дһ����������������ַ����Ƿ�Ϊ��Ч�ַ�������Ч�ַ����������¹���
    //
    //�κ������� (?��������Ӧ�������� )��
    //�κ������� )?��������Ӧ�������� (?��
    //������ ( �����ڶ�Ӧ��������֮ǰ )��
    //*?���Ա���Ϊ���������� )?���򵥸������� (?����һ�����ַ�����
    //һ�����ַ���Ҳ����Ϊ��Ч�ַ�����
    //ʾ�� 1:
    //
    //����: "()"
    //���: True
    //ʾ�� 2:
    //
    //����: "(*)"
    //���: True
    //ʾ�� 3:
    //
    //����: "(*))"
    //���: True
    //ע��:
    //
    //�ַ�����С���� [1��100] ��Χ�ڡ�
    //
    //��Դ�����ۣ�LeetCode��
    //���ӣ�https://leetcode-cn.com/problems/valid-parenthesis-string
    //����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
}

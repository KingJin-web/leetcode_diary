package com.king.year_2021.M08;

import com.king.util.Helper;
import com.king.util.ListNode;

import java.util.Stack;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-08-06 10:19
 */
public class Test6 {

    /**
     * ��ָ Offer II 001. ��������
     * https://leetcode-cn.com/problems/xoh6Oh/
     * ������������ a �� b �������ǵĳ������� a/b ��Ҫ�󲻵�ʹ�ó˺� '*'������ '/' �Լ�������� '%' ��
     */
    public static class T1 {
        public int divide(int a, int b) {
            //���⴦�� -2^31/ -1 = 2^31 ���
            if (a == Integer.MIN_VALUE && b == -1) {
                return Integer.MAX_VALUE;
            }
            boolean k = (a > 0 && b > 0) || (a < 0 && b < 0);
            int result = 0;
            a = -Math.abs(a);
            b = -Math.abs(b);
            while (a <= b) {
                int temp = b;
                int c = 1;
                while (a - temp <= temp) {
                    temp = temp << 1;
                    c = c << 1;
                }
                a -= temp;
                result += c;
            }
            return k ? result : -result;
        }

        public static void main(String[] args) {
            T1 t1 = new T1();
            Helper.print(Math.abs(0x80000000));
            Helper.print(t1.divide(-2147483648
                    , 2));

        }
    }

    /**
     * ��ָ Offer 05. �滻�ո�
     * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
     * ��ʵ��һ�����������ַ��� s �е�ÿ���ո��滻��"%20"��
     * ���룺s = "We are happy."
     * �����"We%20are%20happy."
     */
    public static class T2 {
        static T2 t2 = new T2();

        /**
         * ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û�
         * �ڴ����ģ� 36.3 MB , ������ Java �ύ�л����� 36.42% ���û�
         *
         * @param s
         * @return
         */
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(c);
                }
            }

            return String.valueOf(sb);
        }

        /**
         * ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û�
         * �ڴ����ģ� 36.1 MB , ������ Java �ύ�л����� 77.23% ���û�
         *
         * @param s
         * @return
         */
        public String replaceSpace1(String s) {

            return s.replace(" ", "%20");
        }

        public static void main(String[] args) {

            Helper.print(t2.replaceSpace("We are happy"));
            Helper.print("We are happy".replace(" ", "%20"));
        }
    }

    /**
     * ��ָ Offer 06. ��β��ͷ��ӡ����
     * ����һ�������ͷ�ڵ㣬��β��ͷ����������ÿ���ڵ��ֵ�������鷵�أ���
     * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
     */
    public static class T3 {
        /**
         * ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û�
         * �ڴ����ģ� 39 MB , ������ Java �ύ�л����� 59.42% ���û�
         *
         * @param head
         * @return
         */
        public int[] reversePrint(ListNode head) {

            ListNode listNode = head;
            int count = 0;
            while (listNode != null) {

                ++count;
                listNode = listNode.next;
            }
            int[] arr = new int[count];
            listNode = head;
            for (int i = arr.length - 1; i >= 0; --i) {
                arr[i] = listNode.val;
                listNode = listNode.next;
            }
            return arr;
        }

        public int[] reversePrint1(ListNode head) {
            Stack<ListNode> stack = new Stack<ListNode>();
            ListNode temp = head;
            while (temp != null) {
                stack.push(temp);
                temp = temp.next;
            }
            int size = stack.size();
            int[] print = new int[size];
            for (int i = 0; i < size; i++) {
                print[i] = stack.pop().val;
            }
            return print;
        }

        /**
         * ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 73.71% ���û� �ڴ����ģ� 39 MB , ������ Java �ύ�л����� 52.39% ���û� ��ҫһ��:
         * @param head
         * @return
         */
        public int[] reversePrint2(ListNode head) {
            Stack<Integer> stack = new Stack<Integer>();
            ListNode temp = head;
            while (temp != null) {
                stack.push(temp.val);
                temp = temp.next;
            }
            int size = stack.size();
            int[] print = new int[size];
            for (int i = 0; i < size; i++) {
                print[i] = stack.pop();
            }
            return print;
        }
        public static void main(String[] args) {
            T3 t3 = new T3();
            ListNode l = new ListNode(Helper.getArrays(1, 3, 2));
            Helper.print(t3.reversePrint(l));
            Helper.print(t3.reversePrint1(l));
            Helper.print(t3.reversePrint2(l));
        }
    }

}

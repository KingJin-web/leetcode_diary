package com.king.year_2021.M10;


import com.king.util.Helper;
import com.king.util.MyPrint;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @program: leetcode
 * @description: 284. ��̽������
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/peeking-iterator
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-10-05 00:44
 */
public class Test5 {

    //�������һ��������������֧�� hasNext �� next �����⣬��֧�� peek ������
    //
    //ʵ�� PeekingIterator �ࣺ
    //
    //PeekingIterator(int[] nums) ʹ��ָ���������� nums ��ʼ����������
    //int next() ���������е���һ��Ԫ�أ�����ָ���ƶ����¸�Ԫ�ش���
    //bool hasNext() ��������д�����һ��Ԫ�أ����� true �����򣬷��� false ��
    //int peek() ���������е���һ��Ԫ�أ��� �� �ƶ�ָ�롣

    public static void main(String[] args) {
        //���룺
        //["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
        //[[[1, 2, 3]], [], [], [], [], []]
        //�����
        //[null, 1, 2, 2, 3, false]

        Iterator<Integer> iterator = Arrays.stream(Helper.getArrays(1,2,3)).iterator();
       // iterator.forEachRemaining(System.out::println);
        MyPrint.print(iterator);
        PeekingIterator test5 = new PeekingIterator(iterator);
        MyPrint.print(test5);
        MyPrint.print(test5.next());
        MyPrint.print(test5.peek());
        MyPrint.print(test5.next());
        MyPrint.print(test5.peek());
        MyPrint.print(test5.hasNext());

    }
}
//ִ����ʱ�� 4 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 38.5 MB , ������ Java �ύ�л����� 36.47% ���û�
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer next = null; // ��һ��peekʱ, ���������Ԫ��

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        next = iterator.next();
    }

    public Integer peek() {
        return next;
    }

    @Override
    public Integer next() {
        Integer ret = next;
        next = iterator.hasNext() ? iterator.next() : null;
        return ret;

    }
    @Override
    public boolean hasNext() {
        return next != null;
    }
}


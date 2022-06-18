package com.king.year_2021.M10;

import com.king.util.Helper;
import com.king.util.MyPrint;

import java.util.*;

/**
 * @program: leetcode
 * @description: 1436. �����յ�վ
 * //��Դ�����ۣ�LeetCode��
 * //���ӣ�https://leetcode-cn.com/problems/destination-city
 * //����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-10-01 22:31
 */
public class Test1 {
    //����һ��������·ͼ������·ͼ�е�������·������ paths ��ʾ������ paths[i] = [cityAi, cityBi] ��ʾ����·����� cityAi ֱ��ǰ�� cityBi �������ҳ�������е��յ�վ����û���κο���ͨ���������е���·�ĳ��С�
    //
    //��Ŀ���ݱ�֤��·ͼ���γ�һ��������ѭ������·�����ǡ��һ�������յ�վ��

    //ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 38.3 MB , ������ Java �ύ�л����� 5.00% ���û�
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (List<String> list : paths) {
            set.add(list.get(0));
        }
        for (List<String> list : paths) {
            String s = list.get(1);
            if (set.add(s)) {
                return s;
            }
        }
        return "";
    }

    //ִ����ʱ�� 2 ms , ������ Java �ύ�л����� 94.47% ���û� �ڴ����ģ� 38.2 MB , ������ Java �ύ�л����� 22.89% ���û�
    public String destCity1(List<List<String>> paths) {
        Set<String> citiesA = new HashSet<String>();
        for (List<String> path : paths) {
            citiesA.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!citiesA.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        //[["B","C"],["D","B"],["C","A"]]
        list.add(Helper.getList("B","C"));
        list.add(Helper.getList("D","B"));
        list.add(Helper.getList("C","A"));
        Test1 test1 = new Test1();
        MyPrint.print(test1.destCity(list));
    }

}

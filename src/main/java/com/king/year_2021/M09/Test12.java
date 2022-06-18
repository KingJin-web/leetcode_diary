package com.king.year_2021.M09;

import com.king.util.MyPrint;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 447. �����ڵ�����
 * @author: King
 * @create: 2021-09-13 21:10
 */
public class Test12 {
    //JAVA ʵ�֣� �����˼·��ʵҲ�Ƚϼ򵥣�����һ���������֮��ľ��룬ʹ�ù�ϣ��洢����ͬһ������ֶ�Σ�
    //������γɻ����ڡ�����ͬһ������� n �Σ������ֹ��ɿ��Ƴ������ڵ����� sum = n*(n-1) ��
    // ���˿�ʼֻ�������洢����ϣ��Ȼ�󰴸ù�ʽ�ۼӵõ��������
    // �ο����ٶȵ�һ�Ĵ𰸣��Ż����£�
    // ���赱ǰͬһ���������Ϊ n, ����������Ϊ n*(n-1), ���ٳ���һ��ͬһ����ʱ�������ڵ�����ӦΪ (n+1)*n����֮ǰ���
    // (n+1)*n - n*(n-1)= 2*n�� ����ֻ��Ҫ�����𰸼��� 2*n, ��� n+1 �ٴ洢����ϣ���С�


    //ִ����ʱ�� 71 ms , ������ Java �ύ�л����� 93.92% ���û� �ڴ����ģ� 38.3 MB , ������ Java �ύ�л����� 65.82% ���û�
    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        int ans = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    double dis = Math.pow(points[i][0] - points[j][0], 2)
                            + Math.pow(points[i][1] - points[j][1], 2);
                    if (!map.containsKey(dis)) {
                        map.put(dis, 1);
                    } else {
                        int n = map.get(dis);
                        ans += 2 * n;
                        map.put(dis, 1 + n);
                    }
                }
            }
            map.clear();
        }
        return ans;
    }

    public static void main(String[] args) {
        int [][] nums = new int[][]{{0,0},{1,0},{2,0}};
        Test12 test12 = new Test12();
        MyPrint.print(test12.numberOfBoomerangs(nums));
    }
}
//����ƽ����n �� ������ͬ �ĵ�points ������ points[i] = [xi, yi] �������� ���ɵ�(i, j, k) ��ʾ��Ԫ�� ��
// ����i��j֮��ľ����i��k֮��ľ�����ȣ���Ҫ����Ԫ���˳�򣩡�
//
//����ƽ�������л����ڵ�������
//
//
//ʾ�� 1��
//
//���룺points = [[0,0],[1,0],[2,0]]
//�����2
//���ͣ�����������Ϊ [[1,0],[0,0],[2,0]] �� [[1,0],[2,0],[0,0]]
//ʾ�� 2��
//
//���룺points = [[1,1],[2,2],[3,3]]
//�����2
//ʾ�� 3��
//
//���룺points = [[1,1]]
//�����0


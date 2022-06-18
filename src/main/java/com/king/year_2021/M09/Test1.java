package com.king.year_2021.M09;

import com.king.util.Helper;

/**
 * @program: leetcode
 * @description: 165. �Ƚϰ汾��
 * //���ӣ�https://leetcode-cn.com/problems/compare-version-numbers
 * @author: King
 * @create: 2021-09-01 21:04
 */
public class Test1 {
    //���������汾�� version1 �� version2 ������Ƚ����ǡ�
    //
    //�汾����һ�������޶�����ɣ����޶�����һ�� '.' ���ӡ�ÿ���޶����� ��λ���� ��ɣ����ܰ��� ǰ���� ��
    // ÿ���汾�����ٰ���һ���ַ����޶��Ŵ����ұ�ţ��±�� 0 ��ʼ������ߵ��޶����±�Ϊ 0 ����һ���޶����±�Ϊ 1 ���Դ����ơ�
    // ���磬2.5.33 �� 0.1 ������Ч�İ汾�š�
    //�Ƚϰ汾��ʱ���밴�����ҵ�˳�����αȽ����ǵ��޶��š��Ƚ��޶���ʱ��ֻ��Ƚ� �����κ�ǰ����������ֵ ��
    // Ҳ����˵���޶��� 1 ���޶��� 001 ��� ������汾��û��ָ��ĳ���±괦���޶��ţ�����޶�����Ϊ 0 ��
    // ���磬�汾 1.0 С�ڰ汾 1.1 ����Ϊ�����±�Ϊ 0 ���޶�����ͬ�����±�Ϊ 1 ���޶��ŷֱ�Ϊ 0 �� 1 ��0 < 1 ��

    //���ع������£�
    //
    //��� version1 > version2 ���� 1��
    //��� version1 < version2 ���� -1��
    //����֮�ⷵ�� 0��

    //ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 80.56% ���û� �ڴ����ģ� 36.5 MB , ������ Java �ύ�л����� 47.26% ���û�
    public int compareVersion1(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int l1 = str1.length, l2 = str2.length;
        for (int i = 0; i < l1 || i < l2; ++i) {
            int x = 0, y = 0;
            if (i < l1) {
                x = Integer.parseInt(str1[i]);
            }
            if (i < l2) {
                y = Integer.parseInt(str2[i]);
            }
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

    //˫ָ��
    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 36.3 MB , ������ Java �ύ�л����� 87.25% ���û�
    public int compareVersion(String version1, String version2) {
        char[] chars1 = version1.toCharArray(), chars2 = version2.toCharArray();
        int l1 = chars1.length, l2 = chars2.length;
        for (int i = 0, j = 0; i < l1 || j < l2; ) {
            int x = 0;
            while (i < l1 && !(chars1[i] == '.')) {
                x = x * 10 + chars1[i] - '0';
                ++i;
            }
            ++i; // �������
            int y = 0;
            while (j < l2 && !(chars2[j] == '.')) {
                y = y * 10 + chars2[j] - '0';
                ++j;
            }
            ++j;

            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        //���룺version1 = "7.5.2.4", version2 = "7.5.3"
        //�����-1
        String version1 = "7.5.2.4", version2 = "7.5.3";
        Test1 test1 = new Test1();

        Helper.print(test1.compareVersion(version1, version2));

        version1 = "1.0.1";
        version2 = "1";
        Helper.print(test1.compareVersion(version1, version2));
    }

}


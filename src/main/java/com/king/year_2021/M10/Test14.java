package com.king.year_2021.M10;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @program: leetcode
 * @description: ��ָ Offer II 069. ɽ������Ķ���
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/B1IidL
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-10-14 00:04
 */
public class Test14 {

    //�����������Ե����� arr ��Ϊ ɽ�����飨ɽ�����飩 ��
    //
    //arr.length >= 3
    //���� i��0 < i< arr.length - 1��ʹ�ã�
    //arr[0] < arr[1] < ... arr[i-1] < arr[i]
    //arr[i] > arr[i+1] > ... > arr[arr.length - 1]
    //������������ɵ�ɽ������ arr �������κ����� arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
    // ���±� i?����ɽ�嶥����

    //ִ����ʱ�� 5 ms , ������ Java �ύ�л����� 11.08% ���û� �ڴ����ģ� 38.7 MB , ������ Java �ύ�л����� 42.30% ���û�
    public int peakIndexInMountainArray1(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        List<Integer> a = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return a.indexOf(max);
    }

    // ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 38.5 MB , ������ Java �ύ�л����� 85.00% ���û�
    public int peakIndexInMountainArray2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return 0;
    }
    //ʱ�临�Ӷȣ�O(n)
    //�ռ临�Ӷȣ�O(1)


    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    //ʱ�临�Ӷȣ�O(\log n)
    //�ռ临�Ӷȣ�O(1)

    public static void main(String[] args) {
        Test14 test14 = new Test14();
        int n1 = test14.peakIndexInMountainArray(LeetcodeUtil.stringToIntegerArray(" [24,69,100,99,79,78,67,36,26,19]"));
        MyPrint.print(n1);
    }

}

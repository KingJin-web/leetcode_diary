package com.king.year_2021.M12;

import com.king.util.MyPrint;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: 1816. �ضϾ���
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/truncate-sentence
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-12-06 22:25
 */
public class Test6 {

    //ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 53.65% ���û� �ڴ����ģ� 36.9 MB , ������ Java �ύ�л����� 24.02% ���û�
    public String truncateSentence(String s, int k) {
      String[] strings = s.split(" ");
      StringBuilder stringBuilder = new StringBuilder();
      int i = 0;
      while (i < k - 1){
          stringBuilder.append(strings[i]).append(" ");
          ++i;
      }
      stringBuilder.append(strings[k - 1]);
      return stringBuilder.toString();
    }

    public String truncateSentence2(String s, int k) {
        return Arrays.stream(s.split(" ")).limit(k).collect(Collectors.joining(" "));
    }
    public String truncateSentence1(String s, int k) {
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == ' ' && --k == 0)
                return s.substring(0, i);
        return s;
    }

    public static void main(String[] args) {
        Test6 test6 = new Test6();

        //���룺s = "Hello how are you Contestant", k = 4
        //�����"Hello how are you"
        //���ͣ�
        //s �еĵ���Ϊ ["Hello", "how" "are", "you", "Contestant"]
        //ǰ 4 ������Ϊ ["Hello", "how", "are", "you"]
        //��ˣ�Ӧ������ "Hello how are you"
        //

        MyPrint.print(test6.truncateSentence("Hello how are you Contestant", 4));
    }
}

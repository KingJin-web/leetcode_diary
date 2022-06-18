package com.king.year_2021.M09;

import com.king.util.Helper;
import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 68. �ı����Ҷ���
 * ���ߣ�LeetCode-Solution
 * ���ӣ�https://leetcode-cn.com/problems/text-justification/solution/wen-ben-zuo-you-dui-qi-by-leetcode-solut-dyeg/
 * ��Դ�����ۣ�LeetCode��
 * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-09-09 22:37
 */
public class Test8 {

    //ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 71.13% ���û� �ڴ����ģ� 36.6 MB , ������ Java �ύ�л����� 78.21% ���û�
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<String>();
        int right = 0, n = words.length;
        while (true) {
            int left = right; // ��ǰ�еĵ�һ�������� words ��λ��
            int sumLen = 0; // ͳ����һ�е��ʳ���֮��
            // ѭ��ȷ����ǰ�п��ԷŶ��ٵ��ʣ�ע�ⵥ��֮��Ӧ������һ���ո�
            while (right < n && sumLen + words[right].length() + right - left <= maxWidth) {
                sumLen += words[right++].length();
            }

            // ��ǰ�������һ�У���������룬�ҵ���֮��Ӧֻ��һ���ո�����ĩ���ʣ��ո�
            if (right == n) {
                StringBuffer sb = join(words, left, n, " ");
                sb.append(blank(maxWidth - sb.length()));
                ans.add(sb.toString());
                return ans;
            }

            int numWords = right - left;
            int numSpaces = maxWidth - sumLen;

            // ��ǰ��ֻ��һ�����ʣ��õ�������룬����ĩ���ʣ��ո�
            if (numWords == 1) {
                StringBuffer sb = new StringBuffer(words[left]);
                sb.append(blank(numSpaces));
                ans.add(sb.toString());
                continue;
            }

            // ��ǰ�в�ֻһ������
            int avgSpaces = numSpaces / (numWords - 1);
            int extraSpaces = numSpaces % (numWords - 1);
            StringBuffer sb = new StringBuffer();
            sb.append(join(words, left, left + extraSpaces + 1, blank(avgSpaces + 1))); // ƴ�Ӷ����һ���ո�ĵ���
            sb.append(blank(avgSpaces));
            sb.append(join(words, left + extraSpaces + 1, right, blank(avgSpaces))); // ƴ�����൥��
            ans.add(sb.toString());
        }
    }

    // blank ���س���Ϊ n ���ɿո���ɵ��ַ���
    public String blank(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            sb.append(' ');
        }
        return sb.toString();
    }


    // join ������ sep ƴ�� [left, right) ��Χ�ڵ� words ��ɵ��ַ���
    public StringBuffer join(String[] words, int left, int right, String sep) {
        StringBuffer sb = new StringBuffer(words[left]);
        for (int i = left + 1; i < right; ++i) {
            sb.append(sep);
            sb.append(words[i]);
        }
        return sb;
    }

    public static void main(String[] args) {
        //����:
        //words = ["This", "is", "an", "example", "of", "text", "justification."]
        //maxWidth = 16
        //���:
        //[
        //"This   is   an",
        //"example of text",
        //"justification. "
        //]

        Test8 test8 = new Test8();
        List<String> list = test8.fullJustify(Helper.getArrays("This", "is", "an", "example", "of", "text", "justification."), 16);
        MyPrint.print(list);
        System.out.println(list);

    }


}




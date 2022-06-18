package com.king.year_2021.M12;

import com.king.util.MyPrint;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 1446. �����ַ�
 * https://leetcode-cn.com/problems/consecutive-characters/
 * @author: King
 * @create: 2021-12-02 02:25
 */
public class Test1 {

    //����һ���ַ��� s ���ַ����ġ�����������Ϊ��ֻ����һ���ַ�����ǿ����ַ����ĳ��ȡ�
    //
    //���㷵���ַ�����������

    public static void main(String[] args) {
        //���룺s = "abbcccddddeeeeedcba"

        //�����5
        //���ͣ����ַ��� "eeeee" ����Ϊ 5 ��ֻ�����ַ� 'e' ��
        Test1 test1 = new Test1();
        MyPrint.print(test1.maxPower("abbcccddddeeeeedcba"));
        MyPrint.print(test1.maxPower1("abbcccddddeeeeedcba"));

    }

    //ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 38.4 MB , ������ Java �ύ�л����� 14.54% ���û�
    public int maxPower(String s) {
        //  Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int n = s.length();
        int ans = 1, cnt = 1;
        for (int i = 1; i < n; ++i) {
            if (chars[i] == chars[i - 1]){
                ++cnt;
                ans = Math.max(ans,cnt);
            }else {
                cnt = 1;
            }
        }

        return ans;
    }

    public int maxPower1(String s) {
        int ans = 1, cnt = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ++cnt;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 1;
            }
        }
        return ans;
    }
}

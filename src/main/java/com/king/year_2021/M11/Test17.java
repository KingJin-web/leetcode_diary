package com.king.year_2021.M11;

/**
 * @program: leetcode
 * @description: 318. ��󵥴ʳ��ȳ˻�
 * @author: King
 * @create: 2021-11-17 22:36
 */
public class Test17 {

        public int maxProduct(String[] words) {
            /**
             ȫ��Сд��ĸ, ������һ��32Ϊ������ʾһ��word�г��ֵ���ĸ,
             hash[i]��ŵ�i�����ʳ��ֹ�����ĸ, a��Ӧ32λ���������һλ,
             b��Ӧ�����ĵ����ڶ�λ, ��������. ʱ�临�Ӷ�O(N^2)
             �ж��������ʰ�λ��Ľ��, ������Ϊ0�ҳ��Ȼ��������������
             **/
            int n = words.length;
            int[] hash = new int[n];
            int max = 0;
            for(int i = 0; i < n; ++i) {
                for(char c : words[i].toCharArray())
                    hash[i] |= 1 << (c-'a');
            }

            for(int i = 0; i < n-1; ++i) {
                for(int j = i+1; j < n; ++j) {
                    if((hash[i] & hash[j]) == 0)
                        max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
            return max;
        }


}

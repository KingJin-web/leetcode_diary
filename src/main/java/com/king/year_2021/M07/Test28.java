package com.king.year_2021.M07;

import com.king.util.Helper;

/**
 * @program: leetcode
 * @description: 1047. ɾ���ַ����е����������ظ���
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 * @author: King
 * @create: 2021-07-25 21:30
 */
public class Test28 {
    static Test28 t28 = new Test28();

    public String removeDuplicates(String S) {
        int index = -1;
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (index >= 0 && chars[index] == chars[i]) {
                index--;
            } else {
                index++;
                chars[index] = chars[i];
            }
        }
        return String.copyValueOf(chars, 0, index + 1);
    }

    /**
     * �ٴγ�ʱ
     *
     * @param S
     * @return
     */
    public String removeDuplicates2(String S) {
        for (int i = 1; i < S.length(); ++i) {
            if (S.charAt(i - 1) == S.charAt(i)) {
                S = S.substring(0, i - 1) + S.substring(i + 1);
                i = 0;
            }
        }
        return S;
    }

    public static void main(String[] args) {
        Helper.print(t28.removeDuplicates("abbaca"));
        Helper.print(t28.removeDuplicates1("abbaca"));
    }

    /**
     * ��ϧ��ʱ��
     *
     * @param S
     * @return
     */
    public String removeDuplicates1(String S) {
        int now = S.length();
        int next = 1;
        while (now != next) {
            now = S.length();
            S = S.replace("aa", "").replace("bb", "").
                    replace("cc", "").replace("dd", "").
                    replace("ee", "").replace("ff", "").
                    replace("gg", "").replace("hh", "").
                    replace("ii", "").replace("jj", "").
                    replace("kk", "").replace("ll", "").
                    replace("mm", "").replace("nn", "").
                    replace("oo", "").replace("pp", "").
                    replace("qq", "").replace("rr", "").
                    replace("ss", "").replace("tt", "").
                    replace("uu", "").replace("vv", "").
                    replace("ww", "").replace("xx", "").
                    replace("yy", "").replace("zz", "");
            next = S.length();

        }


        return S;
    }
}

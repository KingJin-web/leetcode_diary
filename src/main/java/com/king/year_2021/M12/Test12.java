package com.king.year_2021.M12;

/**
 * @program: leetcode
 * @description: 709. ת����Сд��ĸ
 * https://leetcode-cn.com/problems/to-lower-case/
 * @author: King
 * @create: 2021-12-12 23:39
 */
public class Test12 {
    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 36.3 MB , ������ Java �ύ�л����� 87.92% ���û�
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            sb.append(Character.toLowerCase(ch));
        }

        return sb.toString();

    }

    public static void main(String[] args) {

    }
}

package com.king.year_2021.contest.season_2021.spring;

import com.king.util.MyPrint;
import com.king.util.LeetcodeUtil;

/**
 * @program: leetcode
 * @description: 1. ��Ӳ��
 * <p>
 * https://leetcode-cn.com/problems/na-ying-bi/submissions/
 * @author: King
 * @create: 2021-09-11 17:19
 */
public class Test1 {
    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 35.5 MB , ������ Java �ύ�л����� 85.27% ���û�
    public int minCount(int[] coins) {
        int result = 0;
        for (int coin : coins) {
            result += coin / 2 + coin % 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
//        ���룺[4,2,1]
//        �����4
        MyPrint.print(test1.minCount(LeetcodeUtil.stringToIntegerArray("[4,2,1]")));
    }
}

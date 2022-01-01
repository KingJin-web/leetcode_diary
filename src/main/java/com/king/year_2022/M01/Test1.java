package com.king.year_2022.M01;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

/**
 * @program: leetcode_diary
 * @description: 2022. 将一维数组转变成二维数组
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-1d-array-into-2d-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2022-01-01 17:23
 */

public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();


        //输入：original = [1,2,3,4], m = 2, n = 2
        //输出：[[1,2],[3,4]]
        //解释：
        //构造出的二维数组应该包含 2 行 2 列。
        //original 中第一个 n=2 的部分为 [1,2] ，构成二维数组的第一行。
        //original 中第二个 n=2 的部分为 [3,4] ，构成二维数组的第二行。
        //

        MyPrint.print(test1.construct2DArray(LeetcodeUtil.stringToIntegerArray("[1,2,3,4]"),2,2));
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        int ln = original.length;
        if (n * m != ln) {
            return new int[0][];
        }
        int[][] result = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                result[i][j] = original[index++];
        return result;
    }

}
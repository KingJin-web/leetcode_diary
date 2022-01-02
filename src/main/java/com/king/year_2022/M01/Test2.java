package com.king.year_2022.M01;

import com.king.util.Helper;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode_diary
 * @description: 390. 消除游戏
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/elimination-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2022-01-02 21:29
 */
public class Test2 {


    //列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
    //
    //从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
    //重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
    //不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
    //给你整数 n ，返回 arr 最后剩下的数字。
    //

    //执行用时： 2 ms , 在所有 Java 提交中击败了 85.24% 的用户
    //内存消耗： 37.3 MB ,在所有 Java 提交中击败了 81.43% 的用户
    //https://blog.csdn.net/afei__/article/details/83689502
    public int lastRemaining1(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }

    public int lastRemaining(int n) {

        // 因此我看评论了, 太妙了
        // 从左到右一定要消除第一个, 此时剩下的数组里的第一个要加一个step
        // 比如1 2 3 4 ... 9, 从左到右消除后第一个是2, 此时的2由first+step=1+1得来, 此时剩下的数是
        // 2 4 6 8, first=2, step=1*2=2, 此时从右往左消除得到的第一个剩下的数first还是2, step=4,
        // 因为剩下了 2 6. 再从左往右消除一定消除第一个, 此时first=first+step=2+4=6, 剩下的数只有1个, 于是返回
        // first   要注意的是, 对于从右往左奇数长度的时候会消除第一个, 因此要考虑
        int first = 1;
        int step = 1;
        int remain = n;
        boolean isLeft = true;
        while (remain > 1) {
            if (isLeft || ((remain & 1) == 1)) {
                first += step;
            }
            isLeft = !isLeft;
            step <<= 1;
            remain >>= 1;
        }
        return first;
    }
    //输入：n = 9
    //输出：6
    public static void main(String[] args) {
        Test2 test2 = Helper.getYoursObj(Test2.class);
        MyPrint.print(test2.lastRemaining(9));
    }
}

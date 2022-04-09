package com.king.year_2022.M04;

/**
 * @program: leetcode_diary
 * @description: 780. 到达终点
 * https://leetcode-cn.com/problems/reaching-points/
 * @author: King
 * @create: 2022-04-09 23:51
 */
public class Test9 {
    public boolean reachingPoints1(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) {
                return true;
            }
            if (tx > ty) {
                tx = tx % ty;
            } else {
                ty = ty % tx;
            }
        }
        return false;
    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) {
                break;
            } // if (tx == sx && ty == sy)

            if (tx > ty) {
                tx -= Math.max(1, (tx - sx) / ty) * ty;
            } // if (tx > ty)
            else {
                ty -= Math.max(1, (ty - sy) / tx) * tx;
            }
        }

        return tx == sx && ty == sy;
    }


}

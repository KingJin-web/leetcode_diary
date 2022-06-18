package com.king.year_2021.M12;

import java.awt.*;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 475. ��ů��
 * @author: King
 * @create: 2021-12-20 23:06
 */
public class Test20 {

    public int findRadius(int[] houses, int[] heaters) {
        // �Ƚ�����������
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0;
        int i = 0;
        for (int house : houses) {
            while (i < heaters.length && heaters[i] < house) {
                // һֱ�ҵ����ڷ����Ҳ����ˮ��
                i++;
            }
            if (i == 0)
                radius = Math.max(radius, heaters[i] - house);
            else if (i == heaters.length)
                // ���һ����ˮ��
                return Math.max(radius, houses[houses.length - 1] - heaters[heaters.length - 1]);
            else
                // �����Ҳ����ˮ���ͷ���������ˮ����ȡС���Ǹ�
                radius = Math.max(radius, Math.min(heaters[i] - house, house - heaters[i - 1]));
        }
        return radius;
    }

    public static void main(String[] args) {

        Frame frame = new Frame();
        Panel panel = new Panel();

        frame.add(panel);

    }
}

package com.king.year_2022.M04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: leetcode_diary
 * @description: 796. 旋转字符串
 * @author: King
 * @create: 2022-04-07 23:49
 */
public class Test7 {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }

    public static void main(String[] args) {
        Test7 test7 = new Test7();

        int[] nums = new int[]{1, 22, 33, 44, 12, 333, 444, 99, 222};
        sleepSort(nums);
        System.out.println(Arrays.toString(nums));
        monkeySort(nums);
        System.out.println(Arrays.toString(nums));

    }

    //猴子排序
    private static void monkeySort(int[] nums) {

        List<Integer> temp = Arrays.stream(nums).boxed().collect(Collectors.toList());
        out:while (true) {
            Collections.shuffle(temp);
            int[] result = temp.stream().mapToInt(Integer::intValue).toArray();
            for (int i = 0; i < result.length - 1; i++) {
                if (result[i] > result[i + 1]) {
                    continue out;
                }
            }
            System.arraycopy(result, 0, nums, 0, result.length);
            break;
        }
    }

    private final static List<Integer> temp = new ArrayList<>();

    //睡眠排序
    private static void sleepSort(int[] nums) {
        for (final int num : nums) {
            new Thread(() -> {
                try {
                    Thread.sleep(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(num);
            }).start();
        }

    }

    static class sleepNum implements Runnable {
        int num;

        public sleepNum(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            temp.add(num);
        }
    }

}

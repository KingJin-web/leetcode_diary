package com.king.year_2021.M12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-12-29 20:35
 */
public class Test29 {
    //1995. ͳ��������Ԫ��
    //����һ�� �±�� 0 ��ʼ ���������� nums �������������������� ��ͬ ��Ԫ�� (a, b, c, d) �� ��Ŀ ��
    //
    //nums[a] + nums[b] + nums[c] == nums[d] ����
    //a < b < c < d


    public static void main(String[] args) {
      try(Scanner scanner = new Scanner(System.in)){
          int n = scanner.nextInt();
          List<Integer> nums = new ArrayList<>(n);
          for(int i = 0; i < n; i++){
              nums.add(scanner.nextInt());
          }

          int max = Collections.max(nums);
          int min = Collections.min(nums);
          int a = Math.abs(max - min);
          int b = Math.abs(nums.indexOf(max) - nums.indexOf(min));
          System.out.println(a + " " +b);
      }
    }


}

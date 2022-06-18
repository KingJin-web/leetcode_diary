package com.king.year_2022.M05;

import com.king.util.MyPrint;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * @author: King
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M05.Test21
 * @date: 2022年05月21日 00:37
 * @description: ${}
 */
public class Test21 {
  private static class A{
      private String name;
      private Integer age;

      public A(String name, Integer age) {
          this.name = name;
          this.age = age;
      }

      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (!(o instanceof A)) return false;
          A a = (A) o;
          return name.equals(a.name) && age.equals(a.age);
      }

      @Override
      public int hashCode() {
          return Objects.hash(name, age);
      }
  }

  private static class B{
      private String name;
      private Integer age;

      public B(String name, Integer age) {
          this.name = name;
          this.age = age;
      }

      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (!(o instanceof A)) return false;
          A a = (A) o;
          return name.equals(a.name) && age.equals(a.age);
      }
  }

    public int repeatedNTimes1(int[] A) {
        int len = A.length;
        int a,b;
        while(true){
            a = (int)(System.nanoTime()%len);
            b = (int)(System.nanoTime()%len);
            if(a!=b && A[a]==A[b]){
                return A[a];
            }
        }
    }
    public int repeatedNTimes2(int[] A) {
        Arrays.sort(A);
        return A[A.length/2]==A[A.length-1]?A[A.length/2]:A[A.length/2-1];
    }
    public int repeatedNTimes3(int[] A) {
        Random r = new Random();
        int len = A.length;
        int a,b;
        while(true){
            a = r.nextInt(len);
            b = r.nextInt(len);
            if(a!=b && A[a]==A[b]){
                return A[a];
            }
        }
    }
    public static void main(String[] args) {
        A a1 = new A("张三",12);
        A a2 = new A("张三",12);
        MyPrint.print(a1.equals(a2));
        MyPrint.print();
        B b1 = new B("张三",12);
        B b2 = new B("张三",12);
        MyPrint.print(b1.equals(b2));
        MyPrint.printObs(a1.hashCode(),a2.hashCode(),b1.hashCode(),b2.hashCode());
    }

}
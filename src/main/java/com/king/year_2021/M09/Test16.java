package com.king.year_2021.M09;

import com.king.util.MyPrint;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @program: leetcode
 * @description: 1115. �����ӡFooBar
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/print-foobar-alternately
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-09-16 19:34
 */
public class Test16 {
    //ִ����ʱ�� 24 ms , ������ Java �ύ�л����� 31.45% ���û� �ڴ����ģ� 38.3 MB , ������ Java �ύ�л����� 93.63% ���û�
    static class FooBar {
        private int n;
        private volatile boolean finish = false;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                while (finish) {
                    Thread.yield();
                }
                printFoo.run();
                finish = true;
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                while (!finish) {
                    Thread.yield();
                }
                printBar.run();
                finish = false;
            }
        }


    }

    public static void main(String[] args) {
        //a��b������runnable ʵ������foo����bar����ִ�е���ԭ����run������
        Runnable a = ()->{
            System.out.print("foo");
        };

        Runnable b = ()->{
            System.out.print("bar");
        };

        FooBar fooBar2 = new FooBar(11);

        //����start���������lamada���ʽ������������
        new Thread(()->{
            try {
                fooBar2.bar(b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                fooBar2.foo(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    //cyclicbarrier
    static class FooBar2 {
        private int n;
        volatile boolean flag=true;
        CyclicBarrier c1 = new CyclicBarrier(2);
        public FooBar2(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag=false;
                try{
                    c1.await();
                }catch(BrokenBarrierException e){
                    e.printStackTrace();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException{
            for (int i = 0; i < n; i++) {
                while(flag){}
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag=true;
                try{
                    c1.await();
                }catch(BrokenBarrierException e){
                    e.printStackTrace();
                }
            }
        }
    }


    //semaphore
    static class FooBar3 {
        private int n;
        Semaphore s1 = new Semaphore(0);
        Semaphore s2 = new Semaphore(0);
        public FooBar3(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                s1.release();
                s2.acquire(1);
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                s1.acquire(1);
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                s2.release();
            }
        }
    }
}





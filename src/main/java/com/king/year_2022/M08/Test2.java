package com.king.year_2022.M08;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年08月02日 18:57
 * @description: 622. 设计循环队列
 */
public class Test2 {
    //设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
    //
    //循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
    //
    //你的实现应该支持如下操作：
    //
    //MyCircularQueue(k): 构造器，设置队列长度为 k 。
    //Front: 从队首获取元素。如果队列为空，返回 -1 。
    //Rear: 获取队尾元素。如果队列为空，返回 -1 。
    //enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
    //deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
    //isEmpty(): 检查循环队列是否为空。
    //isFull(): 检查循环队列是否已满。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode.cn/problems/design-circular-queue
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //思路：
    //1. 循环队列的实现，需要一个数组，数组的长度为k，数组的第一个元素为队首，最后一个元素为队尾。

    private static class MyCircularQueue{
        int[] val;
        int l,r,k;
        public MyCircularQueue(int k) {
            val=new int[3005];
            l=r=0;
            this.k=k;
        }

        public boolean enQueue(int value) {
            if(r-l==k){return false;}
            val[r]=value;
            r++;
            return true;
        }

        public boolean deQueue() {
            if(l==r){return false;}
            l++;
            return true;
        }

        public int Front() {
            return l==r?-1:val[l];
        }

        public int Rear() {
            return l==r?-1:val[r-1];
        }

        public boolean isEmpty() {
            return l==r;
        }

        public boolean isFull() {
            return r-l==k;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.isEmpty());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.isEmpty());

        //MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        //circularQueue.enQueue(1);  // 返回 true
        //circularQueue.enQueue(2);  // 返回 true
        //circularQueue.enQueue(3);  // 返回 true
        //circularQueue.enQueue(4);  // 返回 false，队列已满
        //circularQueue.Rear();  // 返回 3
        //circularQueue.isFull();  // 返回 true
        //circularQueue.deQueue();  // 返回 true
        //circularQueue.enQueue(4);  // 返回 true
        //circularQueue.Rear();  // 返回 4
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode.cn/problems/design-circular-queue
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    }

}
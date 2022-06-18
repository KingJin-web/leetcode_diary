package com.king.year_2021.M12;

import com.king.util.MyPrint;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 1705. ��ƻ���������Ŀ
 * @author: King
 * @create: 2021-12-24 23:35
 */
public class Test24 {
    //982ms
    public int eatenApples(int[] apples, int[] days) {
        int count=0;
        int[] dp = new int[apples.length+20000]; //��dp�����־�ѽ����ƻ��
        for(int i = apples.length-1;i>=0;i--){
            for(int j=i + days[i] - 1;j>=i && apples[i]>0;j--){ //������δ��ʼ���㴦��ʼ���ƻ��
                if(dp[j]==0){
                    dp[j] = Math.max(j - apples[i] + 2, i + 1);
                    count++;
                    apples[i]--;
                }else{
                    j = dp[j] - 1;
                }
            }
        }
        return count;
    }
    //691ms
    public int eatenApples5(int[] apples, int[] days) {
        int count=0;
        int[] dp = new int[apples.length+20000]; //��dp�����־�ѽ����ƻ��
        for(int i = apples.length-1;i>=0;i--){
            int app = apples[i];
            for(int j=i + days[i] - 1;j>=i && app>0;j--){ //������δ��ʼ���㴦��ʼ���ƻ��
                if(dp[j]==0){
                    dp[j]=1;
                    count++;
                    app--;
                }
            }
        }
        return count;
    }
    //298ms
    public int eatenApples4(int[] apples, int[] days) {
        int day = 0;
        //�ҳ�ƻ����δȫ�����õ��������
        for (int i = 0; i < days.length; i++) {
            day = Math.max(i + days[i], day);
        }
        //�±�ֵ��ʾʧЧ���ڣ��洢�ڵ���󼴸��õ�ƻ����
        int[] tmp = new int[day];
        int res = 0;
        for (int i = 0; i < day; i++) {
            //���浱���³�����ƻ��
            if (i < apples.length && apples[i] != 0) {
                tmp[i + days[i] - 1] += apples[i];
            }
            int idx = i;
            //ȡ�����ȸ��õ�ƻ��
            while (idx < day && tmp[idx] == 0) {
                idx++;
            }
            //��ƻ�����ó����Ե�
            if (idx != day) {
                tmp[idx]--;
                res++;
            }
        }
        return res;
    }
    //116ms
    public int eatenApples3(int[] apples, int[] days) {
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a,int[] b){
                return (a[1]+a[2]) - (b[1]+b[2]);
            }
        });
        int max=0;
        for(int i = 0;i < apples.length+20000; i++){
            //���뵱���ƻ��
            if(i < apples.length &&apples[i] > 0 && days[i]>0)
                queue.add(new int[]{apples[i],i,days[i]});
            //��������ڵ�ƻ��
            if(!queue.isEmpty()){
                int[] cur = queue.poll();
                if(cur[0]-- > 0 && i < cur[1] + cur[2]){
                    if(cur[0] > 0)
                        queue.offer(cur);
                    max++;
                }
            }
            //ȡ��������ڵ�ƻ��
            while(!queue.isEmpty() && i + 1== queue.peek()[1] + queue.peek()[2])
                queue.poll();
        }
        return max;
    }
    //9ms
    public int eatenApples2(int[] apples, int[] days) {
        int day = 0;
        //�ҳ�ƻ����δȫ�����õ��������
        for (int i = 0; i < days.length; i++) {
            day = Math.max(i + days[i], day);
        }
        //�±�ֵ��ʾʧЧ���ڣ��洢�ڵ���󼴸��õ�ƻ����
        int[] tmp = new int[day];
        int curMax = day,res = 0;
        for (int i = 0; i < day; i++) {
            //���浱���³�����ƻ��
            if (i < apples.length && apples[i] != 0) {
                tmp[i + days[i] - 1] += apples[i];
                curMax = Math.min(curMax,i + days[i] - 1);
            }
            //��ƻ�����ó����Ե�
            int idx = Math.max(i,curMax);
            while (idx < day && tmp[idx] == 0) {
                idx++;
            }
            if (idx != day) {
                tmp[idx]--;
                res++;
            }
        }
        return res;
    }
    //2ms
    public int eatenApples1(int[] apples, int[] days) {
        if(apples.length==1) return  Math.min(days[0],apples[0]);
        int n=apples.length,EndDay=0,ZeroDay=0;
        for(int i=0;i<n;++i){
            if(apples[i] != 0 && i+days[i] > EndDay)
                EndDay = i + days[i];
            if(i >= EndDay) //���е�����
                ZeroDay++;
        }
        return EndDay - ZeroDay;
    }

    public static void main(String[] args) {
        Test24 test = new Test24();

        int [] apples = {1,2,3,5,2}, days = {3,2,1,4,2};
        MyPrint.print(test.eatenApples(apples,days));
    }

    //��һ�������ƻ������һ�� n �죬ÿ�춼���Գ������ɸ�ƻ�����ڵ� i �죬���ϻ᳤�� apples[i] ��ƻ������Щƻ�������� days[i] ���Ҳ����˵���� i + days[i] ��ʱ�����ã�����޷�ʳ�á�Ҳ��������ô���죬���ϲ��᳤���µ�ƻ������ʱ�� apples[i] == 0 �� days[i] == 0 ��ʾ��
    //
    //�����ÿ�� ��� ��һ��ƻ������֤Ӫ�����⡣ע�⣬��������� n ��֮�������ƻ����
    //
    //������������Ϊ n ���������� days �� apples ����������ԳԵ���ƻ���������Ŀ��
    //
    //?
    //
    //ʾ�� 1��
    //
    //���룺apples = [1,2,3,5,2], days = [3,2,1,4,2]
    //�����7
    //���ͣ�����ԳԵ� 7 ��ƻ����
    //- ��һ�죬��Ե���һ�쳤������ƻ����
    //- �ڶ��죬��Ե�һ���ڶ��쳤������ƻ����
    //- �����죬��Ե�һ���ڶ��쳤������ƻ����������һ�죬�����쳤������ƻ�����Ѿ������ˡ�
    //- �����쵽�����죬��ԵĶ��ǵ����쳤������ƻ����
    //ʾ�� 2��
    //
    //���룺apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
    //�����5
    //���ͣ�����ԳԵ� 5 ��ƻ����
    //- ��һ�쵽�����죬��ԵĶ��ǵ�һ�쳤������ƻ����
    //- ������͵����첻��ƻ����
    //- ������͵����죬��ԵĶ��ǵ����쳤������ƻ����
    //?
    //
    //��Դ�����ۣ�LeetCode��
    //���ӣ�https://leetcode-cn.com/problems/maximum-number-of-eaten-apples
    //����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
}

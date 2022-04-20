package com.king.year_2022.M04;

/**
 * @program: leetcode_diary
 * @description: 388. 文件的最长绝对路径
 * @author: King
 * @create: 2022-04-20 23:45
 */
public class Test20 {
    public int lengthLongestPath(String input) {
        if(input==null||input.length()==0) return 0;
        String[] words=input.split("\n");
        int[] pathLens=new int[words.length+1];//pathLens[i]存放地i层次的最后面的元素的路径长度
        pathLens[0]=-1;//层次最少是1，为了统一dp操作（具体看下面循环体），取pathLens[0]=-1
        int ans=0;
        //自左向右，dp
        for(String word:words){
            int level=word.lastIndexOf('\t')+1+1;//层次计算
            int nameLen=word.length()-(level-1);//计算名字长度
            //word的父文件夹必定目前是level-1层次的最后一个，因此pathLens[level-1]就是父文件夹路径长度
            //这个word必然是目前本层次的最后一个，因此需要刷新pathLens[level],+1是因为要加一个'\'
            pathLens[level]=pathLens[level-1]+1+nameLen;
            //如果是文件，还需要用路径长度刷新ans
            if(word.contains(".")) ans=Math.max(ans,pathLens[level]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Test20 test20=new Test20();
        System.out.println(test20.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(test20.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }
}

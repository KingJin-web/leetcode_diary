package com.king.year_2022.M06;

/**
 * @author: King
 * @project: leetcode_diary
 * @pcakage: com.king.year_2022.M06.Test10
 * @date: 2022年06月10日 23:52
 * @description: 730. 统计不同回文子序列
 */
public class Test10 {
    int mod=(int)1e9+7;
    public int countPalindromicSubsequences(String s) {
        char[] c =s.toCharArray();
        long[][][] count =new long[4][c.length][c.length];//按照端点分类，因此无需去重
        for(int i=0;i<c.length;i++){count[c[i]-'a'][i][i]=1;}//长度为1的字符串
        for(int d=1;d<c.length;d++){
            for(int i=0;i<c.length-d;i++){
                for(int j=0;j<4;j++){
                    char ch=(char)(j+'a');
                    if(c[i]==ch&&c[i+d]==ch){
                        //c……c*所有的回文串，再加上c、cc
                        count[j][i][i+d]=2;
                        for(int p=0;p<4;p++){count[j][i][i+d]+=count[p][i+1][i+d-1];}
                    }
                    //下边无法配对儿，，1、有单个端点符合，那么更新为含有那个端点的位置；2、否则更新为不含端点的位置
                    else if(c[i]==ch){count[j][i][i+d]=count[j][i][i+d-1];}
                    else if(c[i+d]==ch){count[j][i][i+d]=count[j][i+1][i+d];}
                    else{count[j][i][i+d]=count[j][i+1][i+d-1];}
                    count[j][i][i+d]%=mod;
                }
            }
        }
        long ans=0;
        for(int i=0;i<4;i++){ans+=count[i][0][c.length-1];}
        return (int)(ans%mod);
        
        
    }

    public static void main(String[] args) {

    }
}
package com.cll.cn.algorithm;

/**
 * 打印正整数的划分
 * 例如6
 * 5+1
 * 4+2，4+1+1
 * 3+3,3+2+1,3+1+1+1
 * ...
 *
 */
public class Recursion10 {

    //借助一个数组a来存放之前遍历的结果，start表示当前的位置
    private static void f(int n,int[] a,int start){
        //5+f(1),4+(2)
        if(n<=0){
            for(int i=0;i<start;i++){
                System.out.print(a[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=n;i>0;i--){
            if(start>0 && i>a[start-1]) continue;
            a[start]=i;
            f(n-i,a,start+1);
        }
    }
    public static void main(String[] args) {
        int[] a=new int[1000];
        f(6,a,0);
    }
}

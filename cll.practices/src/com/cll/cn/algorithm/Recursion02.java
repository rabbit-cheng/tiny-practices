package com.cll.cn.algorithm;

/**
 * 递归求数组累加和
 *
 * 可以将递归想象成踢皮球的游戏,可以有多中解法，比如首元素+下一个到最后的加起来，或者二分等等
 */
public class Recursion02 {

    //从0一直到end求和
    private static int fsum1(int[] a,int end){
        if(end<0){
            return 0;
        }
        int x=fsum1(a,end-1);
        return x+a[end];
    }
    //求数组从begin到结束的元素和
    private static int fsum(int[] a,int begin){
        if(begin==a.length){
            return 0;
        }
        int x=fsum(a,begin+1);
        return x+a[begin];
    }
    public static void main(String[] args){
        int[] a={1,2,3,4,5,6,7,8,9};
        int sum=fsum1(a,4);//数组a从第0项累加
        System.out.println(sum);
    }
}

package com.cll.cn.algorithm;

/**
 * 从n个球中取m个球（取出不放回），求有多少中组合方式
 *
 * 思路：此题看起来很圆没有地方下手，但是我们可以虚拟的想象有n球里面有一个特殊的球x
 *     （1）将所有的组合都排放在操场上，其中一堆组合里面有特殊的球x,(即选中x,只需在n-1个球中再选m-1个球即可)
 *     （2）另一堆组合里面没有特殊的球x(即没有选中x,默认x不选，此时需要在n-1个球里面选择m球)
 *     （3）递归的出口：
 *          a.当n<m时，没有取法，返回0；
 *          b.当n=m时，只有一种取法（即全取），返回1；
 *          c.当m==0时，只有一种取法即不取，返回1；
 */
public class Recursion04 {

    private static int f(int n, int m){
        if(n<m) return 0;
        if(n==m) return 1;
        if(m==0) return 1;
        return f(n-1,m-1) + f(n-1,m);
    }
    public static void main(String[] args) {
        int sum=f(10,3);
        System.out.println(sum);
    }
}

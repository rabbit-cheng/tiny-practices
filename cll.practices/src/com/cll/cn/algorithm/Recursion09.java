package com.cll.cn.algorithm;

/**
 * 有m个A和n个B，问有多少中排列
 */
public class Recursion09 {

    private static int g(int m,int n){
        if(m==0 || n==0) return 1;
        return g(m-1,n)+g(m,n-1);//假设第一位为A或第一位不为A
    }
    public static void main(String[] args) {
        System.out.println(g(3,2));
    }
}

package com.cll.cn.algorithm;

import java.util.Scanner;

/**简单递归1
 * 输出0-n
 */
public class Recursion01 {
    private static void fun(int num){
        if(num>0){
            fun(num-1);//打印0-n-1
        }
        System.out.println(num);
    }

    //有范围的打印
    private static void fun1(int start,int end){
        if(start>end){
            return;
        }
        System.out.println(start);
        fun1(start+1,end);
    }
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int num=in.nextInt();
        int num1=in.nextInt();
      //  fun(num);
        fun1(num,num1);
    }
}

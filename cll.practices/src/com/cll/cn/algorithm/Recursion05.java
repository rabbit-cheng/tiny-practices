package com.cll.cn.algorithm;

/**
 * 求n元素的全排列
 * 比如abc的全排列：abc,acb，bac,bca,cba,cab
 */
public class Recursion05 {


    private static void f(char[] data,int k){

        if(k==data.length){
            for(int i=0;i<data.length;i++){
                System.out.print(data[i]);
            }
            System.out.println();
        }
        for(int i=k;i<data.length;i++){
            {char temp=data[k]; data[k]=data[i]; data[i]=temp;}//交换位置
            f(data,k+1);
            {char temp=data[k]; data[k]=data[i]; data[i]=temp;}//回溯（恢复原位）
        }
    }
    public static void main(String[] args){
        char[] data="ABC".toCharArray();
        f(data, 0);
        //如果仅传一个data数组对象，无法改变，观察上面每个元素都可以放在第一个位置,故传入参数k表示当前的交换位置（关注点，与其后的元素交换）
    }
}

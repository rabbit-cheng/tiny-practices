package com.cll.cn.algorithm;

/**
 * 求两个串的最大公共子序列的长度
 * ps:子串需连着，子序列不需要连着
 *
 * 思路：（1）如果两个字符串的第一个字符相等时，则需要继续对去掉第一位的两个子串进行操作+1；
 *       （2）如果两个字符串的第一位不相等，则需要去掉第一个str1[0]与str2进行操作；或者去掉第二个str2[0]与str1进行操作，两种情况取最大值。
 *       （3）终止条件：两个其中任意一个长度为0
 *
 *   注意：该算法只是可行解，如果长度过大，递归过深就不可行
 */
public class Recursion06 {

    private static int f(String str1,String str2){
        if(str1.length()==0 || str2.length()==0) return 0;//终止条件

        if(str1.charAt(0)==str2.charAt(0)){
            return f(str1.substring(1), str2.substring(1))+1;
        }else{
            return Math.max(f(str1.substring(1),str2), f(str1, str2.substring(1)));
        }
    }
    public static void main(String[] args) {
        int k=f("abc","abfcfr");
        System.out.println(k);
    }
}

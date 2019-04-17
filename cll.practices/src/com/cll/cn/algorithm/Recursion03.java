package com.cll.cn.algorithm;

/**
 * 递归比较两个字符串是否相等
 * 不使用原始api(str1.equals(str2))
 *
 * 思路一：先比较第一位，然后取子串进行递归比较
 * 思路二：直接进行取位比较，最后字符串长度一方为空另一方不为空时返回false
 */
public class Recursion03 {

    //思路一
    private static boolean fun(String str1,String str2){
        if(str1.length() != str2.length()) return false;
        //递归终止条件
        if(str1.length() == 0) return true;
        if(str1.charAt(0) != str2.charAt(0))  return false;
        return fun(str1.substring(1),str1.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(fun("abcdde","abcdde"));
    }
}

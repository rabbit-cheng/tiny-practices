package com.cll.cn.algorithm;

/**
 * 求一个字符串的反串
 * 例：abc->cba
 */
public class Recursion07 {

    private static String f(String str){
        if(str.length()<=1){
            return str;
        }
        return f(str.substring(1))+str.charAt(0);
    }
    public static void main(String[] args) {
        System.out.println(f("abcdefcll"));
    }
}

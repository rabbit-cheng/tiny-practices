package com.cll.cn.algorithm;

import java.math.BigInteger;

/**
 * 大整数乘法
 */
public class BigIntegerMul {
    //生成0
    private static String zero(int n){
        if(n==0) return "";
        if(n==1) return "0";
        return zero(n/2)+zero(n/2)+zero(n%2);
    }
    //两个字符串相加
    private static String add(String a,String b){
        if(a.length()<=8 && b.length()<=8){
            return Integer.parseInt(a)+Integer.parseInt(b)+"";
        }
        //将a为两部分
        String a1="0";
        String a2=a;
        if(a.length()>8){
            a1=a.substring(0,a.length()-8);
            a2=a.substring(a.length()-8);
        }
        //将b切分成两部分
        String b1="0";
        String b2=b;
        if(b.length()>8){
            b1=b.substring(0,b.length()-8);
            b2=b.substring(b.length()-8);
        }

        String t=add(a2,b2);
        while(t.length()<8){
                t="0"+t;
        }
        if(t.length()>8){
            return add(add(a1,b1),"1") + t.substring(1);
        }
        return add(a1,b1)+t;
    }

    //两个字符串相乘
    private static String multi(String a,String b){
        if(a.length()<=4 && b.length()<=4){//如果是int类型就直接计算
            return Integer.parseInt(a) * Integer.parseInt(b)+"";
        }
        if(a.length()>4){
            int k=a.length()/2;
            String a1=a.substring(0,k);
            String a2=a.substring(k);
            return add(multi(a1,b)+zero(a2.length()), multi(a2,b));
        }
        return multi(b,a);//当b的长度很长时放在参数a的位置上就好了
    }
    public static void main(String[] args) {
        System.out.println(multi("1234567890987654321666","1234567890987654321555"));
        BigInteger a=new BigInteger("1234567890987654321666");
        BigInteger b=new BigInteger("1234567890987654321555");
        System.out.println(a.multiply(b));
    }
}

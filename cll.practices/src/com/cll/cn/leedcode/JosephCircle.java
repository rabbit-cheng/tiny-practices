package com.cll.cn.leedcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 约瑟夫环：报数问题
 */
public class JosephCircle {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();

        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }

        int count=1;
        int index=0;
        List<Integer> list1=new ArrayList<>();
        while(list.size()>1){
            if(list.size()==index){
                index=0;
            }
            if(count%m==0){
                list1.add(list.remove(index--));
            }
            count++;
            index++;
        }
        for(Integer k:list1){

            System.out.println(k+" ");
        }
        System.out.println(list.get(0));
    }


}

package com.cll.cn.leedcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 出现一次的数组
 * 思路;异或-满足交换律：a^b^c=a^c^b;
 *       异或两数不同：0^n=n;(任何数与0异或为任何数)
 *       异或两数相同：n^n=0;
 *       arr={2,3,2,4,4}
 *       2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
 */
public class OnceOccurrNumber {

    public static int singleNumber(int[] nums) {

        int result=0;
        for(int i=0;i<nums.length;i++){
            result=result^nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int[] nums=new int[50];

        String str=in.nextLine();
        String[] s=str.split(",");
        for(int i=0;i<s.length;i++){
            nums[i]=Integer.parseInt(s[i]);
        }

        System.out.println(singleNumber(nums));
    }

}

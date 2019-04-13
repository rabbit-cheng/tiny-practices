package com.cll.cn.leedcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(in.nextLine(), 0);
        }

        String s = in.nextLine();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String temp = s.substring(i, i + j);
                if (map.containsKey(temp)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
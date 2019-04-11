package com.cll.cn.leedcode;
import java.util.Scanner;

public class RobotWalking {
/**
 * 机器人走过的路径--动态规划
 * @author cll
 *
 */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();

        System.out.println(allWays(m, n));
    }

    private static int allWays(int m, int n) {
        //创建一个二维数组
        int[][] arr= new int[m][n];
        //将arr[0][n]的位置都记上1步长
        for(int i=1;i<n;i++){
            arr[0][i]=1;
        }
        //将arr[m][0]的位置都记上1步长
        for(int j=0;j<m;j++){
            arr[j][0]=1;
        }

        //arr[i][j]=arr[i-1][j]+arr[i][j]
        for(int ii=1;ii<m;ii++){
            for(int jj=1;jj<n;jj++){
                arr[ii][jj]=arr[ii-1][jj]+arr[ii][jj-1];
            }
        }
        return arr[m-1][n-1];
    }
}

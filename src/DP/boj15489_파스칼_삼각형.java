package DP;

import java.util.Scanner;

public class boj15489_파스칼_삼각형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt() - 1;
        int C = sc.nextInt() - 1;
        int W = sc.nextInt();

        int[] start = new int[30];
        for (int i = 1; i < 30; i++) start[i] = start[i - 1] + i;

        int[] pascal = new int[start[29]];
        pascal[0] = 1;

        for (int i = 0; i < 29; i ++) {
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i) {
                    pascal[start[i] + j] = 1;
                    continue;
                }

                pascal[start[i] + j] = pascal[start[i - 1] + j - 1] + pascal[start[i - 1] + j];
            }
        }

        int ret = 0;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j <= i; j++) {
                ret += pascal[start[R + i] + j + C];
            }
        }
        System.out.println(ret);
    }
}

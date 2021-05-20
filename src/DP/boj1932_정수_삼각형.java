package DP;

import java.util.Scanner;

public class boj1932_정수_삼각형 { //dbb1632
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j <= i; j++)
                arr[i][j] = sc.nextInt();

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] += Math.max(arr[i + 1][j], arr[i + 1][j + 1]);
            }
        }
        System.out.println(arr[0][0]);
    }

}

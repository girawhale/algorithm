package DP;

import java.util.Scanner;

public class boj17404_RGB거리2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] rgb = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++)
                rgb[i][j] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        int[][] memo = new int[N][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                memo[0][j] = i == j ? rgb[0][i] : 1_000_001;

            for (int j = 1; j < N; j++) {
                memo[j][0] = rgb[j][0] + Math.min(memo[j - 1][1], memo[j - 1][2]);
                memo[j][1] = rgb[j][1] + Math.min(memo[j - 1][0], memo[j - 1][2]);
                memo[j][2] = rgb[j][2] + Math.min(memo[j - 1][0], memo[j - 1][1]);
            }

            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                ans = Math.min(ans, memo[N - 1][j]);
            }
        }
        System.out.println(ans);
    }
}

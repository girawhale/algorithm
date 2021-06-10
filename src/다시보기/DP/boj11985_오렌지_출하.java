package 다시보기.DP;

import java.util.Scanner;

public class boj11985_오렌지_출하 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();

        int[] orange = new int[N + 1];
        long[] memo = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            orange[i] = sc.nextInt();
            memo[i] = (long) K * i;
        }

        int min, max;
        for (int i = 0; i < N; i++) {
            min = max = orange[i + 1];
            for (int j = 1; j <= M && i + j <= N; j++) {
                min = Math.min(min, orange[i + j]);
                max = Math.max(max, orange[i + j]);

                memo[i + j] = Math.min(memo[i + j], memo[i] + K + (long) j * (max - min));
            }
        }
        System.out.println(memo[N]);
    }
}

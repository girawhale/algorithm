package 다시보기.DP;

import java.util.Scanner;

public class boj14501_퇴사 { //dbb1633
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = new int[N + 1], P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt() - 1;
            P[i] = sc.nextInt();
        }

        int[] memo = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            memo[i] = Math.max(memo[i], memo[i - 1]);
            int t = T[i] + i;
            if (t <= N) memo[t] = Math.max(memo[t], P[i] + memo[i - 1]);
        }
        System.out.println(memo[N]);
    }
}

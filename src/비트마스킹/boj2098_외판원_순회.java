package 비트마스킹;

import java.util.Scanner;

public class boj2098_외판원_순회 {
    static int N, MAX = 987654321;
    static int[][] cost, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        cost = new int[N][N];
        dp = new int[N][1 << N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                cost[i][j] = sc.nextInt();
        }
        System.out.println(solve(1, 0));
    }

    static int solve(int visit, int cur) {
        if (dp[cur][visit] != 0) return dp[cur][visit];
        if (visit == (1 << N) - 1)
            return cost[cur][0] == 0 ? MAX : cost[cur][0];

        int min = MAX;
        for (int i = 0; i < N; i++) {
            if (cost[cur][i] == 0 || (visit & 1 << i) > 0) continue;
            min = Math.min(solve(visit | (1 << i), i) + cost[cur][i], min);
        }

        return dp[cur][visit] = min;
    }
}

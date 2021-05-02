package DP.TreeDP;

import java.util.ArrayList;
import java.util.List;

public class prog72416_매출_하락_최소화 {
    List<Integer>[] adj;
    int[][] memo;
    int[] sales;

    public int solution(int[] sales, int[][] links) {
        int N = sales.length;
        adj = new ArrayList[N];
        memo = new int[N][2];
        this.sales = sales;

        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();
        for (int[] link : links) adj[link[0] - 1].add(link[1] - 1);

        solve(0);

        return Math.min(memo[0][0], memo[0][1]);
    }

    void solve(int idx) {
        memo[idx][1] = sales[idx];

        if (adj[idx].size() == 0) return;

        int diff = Integer.MAX_VALUE;
        int sum = 0;
        for (int a : adj[idx]) {
            solve(a);

            diff = Math.min(diff, memo[a][1] - memo[a][0]);
            sum += Math.min(memo[a][1], memo[a][0]);
        }
        if (diff < 0) diff = 0;
        memo[idx][0] += diff + sum;
        memo[idx][1] += sum;
    }
}

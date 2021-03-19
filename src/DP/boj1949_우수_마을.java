package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class boj1949_우수_마을 {
    static final int TRUE = 1, FALSE = 0;
    static int N;
    static int[] nums;
    static int[][] dp;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        dp = new int[N][2];
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        adj = new ArrayList[N];
        IntStream.range(0, N).forEach(i -> adj[i] = new ArrayList<>());
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1, n2 = Integer.parseInt(st.nextToken()) - 1;
            adj[n1].add(n2);
            adj[n2].add(n1);
        }

        System.out.println(Math.max(dfs(0, FALSE), dfs(0, TRUE) + nums[0]));

    }

    static int dfs(int cur, int prev) {
        if (dp[cur][prev] != 0) return dp[cur][prev];
        int ret = 0;
        visit[cur] = true;

        for (int i : adj[cur]) {
            if (visit[i]) continue;

            if (prev == TRUE) ret += dfs(i, FALSE);
            else ret += Math.max(dfs(i, FALSE), dfs(i, TRUE) + nums[i]);
        }

        visit[cur] = false;
        return dp[cur][prev] = ret;
    }
}

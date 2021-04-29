package 다시보기.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj2533_사회망_서비스 {
    static List<Integer>[] adj;
    static boolean[] visit;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        dp = new int[N][2];
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++)
            adj[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;

            adj[n1].add(n2);
            adj[n2].add(n1);
        }

        visit[0] = true;
        dfs(0);

        System.out.println(Math.min(dp[0][0], dp[0][1]));
    }


    static void dfs(int n) {
        visit[n] = true;
        dp[n][1] = 1;

        for (int a : adj[n]) {
            if (visit[a]) continue;

            dfs(a);
            dp[n][0] += dp[a][1];
            dp[n][1] += Math.min(dp[a][0], dp[a][1]);
        }
    }
}

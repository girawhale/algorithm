package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj12763_지각하면_안_돼 {
    static int ans = Integer.MAX_VALUE;
    static int N, T, M;
    static List<int[]>[] adj;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = sc.nextInt();
        M = sc.nextInt();

        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        int L = sc.nextInt();
        while (L-- > 0) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int t = sc.nextInt();
            int c = sc.nextInt();

            adj[n1].add(new int[]{n2, t, c});
            adj[n2].add(new int[]{n1, t, c});
        }

        visit[1] = true;
        dfs(1, 0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void dfs(int n, int time, int cost) {
        if (time > T || cost > M) return;

        if (n == N) {
            ans = Math.min(ans, cost);
            return;
        }

        for (int[] a : adj[n]) {
            if (visit[a[0]]) continue;

            visit[a[0]] = true;
            dfs(a[0], time + a[1], cost + a[2]);
            visit[a[0]] = false;
        }
    }
}

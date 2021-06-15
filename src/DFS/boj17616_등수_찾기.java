package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj17616_등수_찾기 {
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = nextInt(st), M = nextInt(st), X = nextInt(st);

        visit = new boolean[N + 1];
        List<Integer>[] adj = new ArrayList[N + 1];
        List<Integer>[] rAdj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            rAdj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = nextInt(st), n2 = nextInt(st);
            adj[n1].add(n2);
            rAdj[n2].add(n1);
        }

        int out = dfs(adj, X);
        int in = dfs(rAdj, X);
        System.out.println(in + " " + (N + 1 - out));
    }

    static int dfs(List<Integer>[] adj, int idx) {
        visit[idx] = true;

        int ret = 1;
        for (int a : adj[idx]) {
            if (!visit[a])
                ret += dfs(adj, a);
        }
        return ret;
    }

    private static int nextInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}

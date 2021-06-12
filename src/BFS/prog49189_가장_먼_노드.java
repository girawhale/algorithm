package BFS;

import java.util.*;

public class prog49189_가장_먼_노드 {
    public int solution(int n, int[][] edge) {
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList();

        for (int i = 0; i < edge.length; i++) {
            adj[edge[i][0]].add(edge[i][1]);
            adj[edge[i][1]].add(edge[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];

        queue.add(1);
        visit[1] = true;

        int ans = 0;
        while (true) {
            int size = queue.size();
            if (size == 0) break;
            ans = 0;

            while (size-- > 0) {
                int cur = queue.poll();

                for (int next : adj[cur]) {
                    if (visit[next]) continue;

                    visit[next] = true;
                    ans++;
                    queue.add(next);
                }
            }
        }

        return ans;
    }
}

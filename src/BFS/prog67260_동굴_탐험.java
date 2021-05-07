package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class prog67260_동굴_탐험 {
    public boolean solution(int n, int[][] path, int[][] order) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] p : path) {
            adj[p[0]].add(p[1]);
            adj[p[1]].add(p[0]);
        }

        int[] prev = new int[n];
        for (int[] o : order) {
            prev[o[1]] = o[0];
        }

        if (prev[0] != 0) return false;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n];
        int[] after = new int[n];

        queue.addAll(adj[0]);
        visit[0] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (visit[cur]) continue;
            if (!visit[prev[cur]]) {
                after[prev[cur]] = cur;
                continue;
            }

            visit[cur] = true;
            queue.add(after[cur]);
            queue.addAll(adj[cur]);
        }

        for (boolean v : visit)
            if (!v) return false;

        return true;
    }
}

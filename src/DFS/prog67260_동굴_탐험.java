package DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class prog67260_동굴_탐험 {
    public boolean solution(int n, int[][] path, int[][] order) {
        List<Integer>[]  adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] p : path) {
            adj[p[0]].add(p[1]);
            adj[p[1]].add(p[0]);
        }

        int[] prev = new int[n];
        int[]  after = new int[n];
        boolean[] visit = new boolean[n];
        for (int[] o : order) {
            prev[o[1]] = o[0];
        }

        if (prev[0] != 0) return false;

        visit[0] = true;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int a : adj[0]) stack.push(a);

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            if (visit[cur]) continue;
            if (!visit[prev[cur]]) {
                after[prev[cur]] = cur;
                continue;
            }

            visit[cur] = true;
            for (int a : adj[cur]) stack.push(a);
            stack.push(after[cur]);
        }

        for (boolean v : visit)
            if (!v) return false;

        return true;
    }
}

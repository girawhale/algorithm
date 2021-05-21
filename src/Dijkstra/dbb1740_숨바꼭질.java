package Dijkstra;

import java.util.*;

public class dbb1740_숨바꼭질 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();

        List<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        while (M-- > 0) {
            int n1 = sc.nextInt(), n2 = sc.nextInt();
            adj[n1].add(n2);
            adj[n2].add(n1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (dist[cur[0]] < cur[1]) continue;
            dist[cur[0]] = cur[1];

            int nextDist = cur[1] + 1;
            for (int a : adj[cur[0]]) {
                if (nextDist >= dist[a]) continue;

                dist[a] = nextDist;
                pq.add(new int[]{a, nextDist});
            }
        }

        int idx = 2, cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (dist[idx] < dist[i]) {
                idx = i;
                cnt = 1;
            } else if (dist[idx] == dist[i])
                cnt++;
        }
        System.out.println(idx + " " + dist[idx] + " " + cnt);

    }
}

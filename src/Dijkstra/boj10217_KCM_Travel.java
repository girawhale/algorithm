package Dijkstra;

import java.util.*;

public class boj10217_KCM_Travel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();
            List<int[]>[] adj = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

            while (K-- > 0)
                adj[sc.nextInt()].add(new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()});

            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(o -> o[2]));
            int[][] cost = new int[N + 1][M + 1];
            for (int[] c : cost)
                Arrays.fill(c, 100001);

            queue.add(new int[]{1, 0, 0});
            Arrays.fill(cost[1], 0);

            int ans = -1;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                if (cur[0] == N) {
                    ans = cur[2];
                    break;
                }
                if (cost[cur[0]][cur[1]] < cur[2]) continue;

                for (int[] a : adj[cur[0]]) {
                    int c = cur[1] + a[1], t = cur[2] + a[2];
                    if (M < c || cost[a[0]][c] <= t) continue;

                    int tmp = c;
                    while (tmp <= M && cost[a[0]][tmp] > t)
                        cost[a[0]][tmp++] = t;
                    queue.add(new int[]{a[0], c, t});
                }
            }

            System.out.println(ans == -1 ? "Poor KCM" : ans);
        }
    }
}

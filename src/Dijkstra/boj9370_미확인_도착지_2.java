package Dijkstra;

import java.util.*;

public class boj9370_미확인_도착지_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt(), t = sc.nextInt();
            int s = sc.nextInt(), g = sc.nextInt(), h = sc.nextInt();

            List<int[]>[] adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

            while (m-- > 0) {
                int n1 = sc.nextInt(), n2 = sc.nextInt(), d = sc.nextInt() * 2;
                if (n1 == g && n2 == h || n1 == h && n2 == g) d -= 1;
                adj[n1].add(new int[]{n2, d});
                adj[n2].add(new int[]{n1, d});
            }

            List<Integer> dest = new ArrayList<>();
            while (t-- > 0)
                dest.add(sc.nextInt());
            dest.sort(null);

            int[] dist = new int[n + 1];
            Arrays.fill(dist, 900_000_000);

            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

            queue.add(new int[]{s, 0});

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                if (dist[cur[0]] <= cur[1]) continue;
                dist[cur[0]] = cur[1];

                for (int[] a : adj[cur[0]]) {
                    if (cur[1] + a[1] >= dist[a[0]]) continue;

                    queue.add(new int[]{a[0], cur[1] + a[1]});
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int d : dest)
                if (dist[d] % 2 == 1) sb.append(d).append(' ');

            System.out.println(sb.toString());
        }
    }
}

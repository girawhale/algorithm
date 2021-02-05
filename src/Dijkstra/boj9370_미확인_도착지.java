package Dijkstra;

import java.util.*;

public class boj9370_미확인_도착지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt(), t = sc.nextInt();
            int s = sc.nextInt(), g = sc.nextInt(), h = sc.nextInt();

            List<int[]>[] adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

            while (m-- > 0) {
                int n1 = sc.nextInt(), n2 = sc.nextInt(), d = sc.nextInt();
                adj[n1].add(new int[]{n2, d});
                adj[n2].add(new int[]{n1, d});
            }

            Set<Integer> dest = new HashSet<>();
            TreeSet<Integer> ans = new TreeSet<>();
            while (t-- > 0)
                dest.add(sc.nextInt());

            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] != o2[1] ?
                    Integer.compare(o1[1], o2[1]) : Integer.compare(o2[2], o1[2]));

            queue.add(new int[]{s, 0, -1});

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                if (dist[cur[0]] <= cur[1]) continue;
                dist[cur[0]] = cur[1];
                if (dest.contains(cur[0]) && cur[2] == 1)
                    ans.add(cur[0]);

                for (int[] a : adj[cur[0]]) {
                    if (cur[1] + a[1] > dist[a[0]]) continue;

                    if (cur[0] == g && a[0] == h || cur[0] == h && a[0] == g)
                        queue.add(new int[]{a[0], cur[1] + a[1], 1});
                    else queue.add(new int[]{a[0], cur[1] + a[1], cur[2]});
                }
            }

            ans.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }
}
